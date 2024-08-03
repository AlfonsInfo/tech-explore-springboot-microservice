package tech.explore.microservice.accounts.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.query.QueryByExampleExecutor
import java.util.Optional


@NoRepositoryBean
interface SoftDeleteRepository<T : Any, ID : Any> : JpaRepository<T, ID>, QueryByExampleExecutor<T> , JpaSpecificationExecutor<T>{

    // Only fetch non-deleted entities
    @Query("select e from #{#entityName} e where e.isDeleted = false")
    @Override
    override fun findAll(): List<T>

    // Only fetch entity by ID when it has not been soft-deleted
    @Query("select e from #{#entityName} e where e.isDeleted = false and e.id = ?1")
    @Override
    override fun findById(id: ID): Optional<T>

    // Only fetch the entities which have been soft deleted
    @Query("select e from #{#entityName} e where e.isDeleted = true")
    fun findAllDeleted(): List<T>

    // Update deleted property instead of deleting
    @Modifying
    @Query("update #{#entityName} e set e.isDeleted = true, e.deletedAt = current_timestamp  where e.id = ?1")
    @Override
    override fun deleteById( id: ID)


    @Modifying
    @Query("update #{#entityName} e set e.isDeleted = true, e.isActive = false, e.deletedAt = current_timestamp, e.deletedBy = ?1  where e.id = ?2")
    @Override
    fun deleteAndInactiveById(user : String, id: ID)


    @Modifying
    @Query("update #{#entityName} e set e.isActive = false where e.id = ?1")
    @Override
    fun inactiveById(id: ID)


    // Update deleted properties instead of deleting
    @Modifying
    @Query("update #{#entityName} e set e.isDeleted = true, e.deletedAt = current_timestamp where e.id in ?1")
    @Override
    override fun deleteAllById(ids: Iterable<ID>)

    // Permanently remove an entity by ID
    @Modifying
    @Query("delete from #{#entityName} e where e.id = ?1")
    fun hardDeleteById(id: ID)

    // Permanently remove multiple entities by IDs
    @Modifying
    @Query("delete from #{#entityName} e where e.id in ?1")
    fun hardDeleteAllById(ids: Iterable<ID>?)


    @Modifying
    @Query("update #{#entityName} e set e.isActive = false , isDeleted = true, e.deletedBy = ?1 where e.id in ?2")
    @Override
    fun inactiveAndDeleteAllById(name : String, ids: Iterable<ID>)

    @Query("SELECT count(e)>0  FROM #{#entityName} e WHERE e.id = ?1 AND e.isActive = true AND e.isDeleted = false")
    fun existAndActiveById(id : ID) : Boolean
}