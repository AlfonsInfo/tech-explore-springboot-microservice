package tech.explore.microservice.accounts.service.impl

import org.springframework.stereotype.Service
import tech.explore.microservice.accounts.domain.constants.CardConstants
import tech.explore.microservice.accounts.domain.dto.AccountsDto
import tech.explore.microservice.accounts.domain.dto.CardsDto
import tech.explore.microservice.accounts.domain.entity.CardsEntity
import tech.explore.microservice.accounts.domain.entity.CustomerEntity
import tech.explore.microservice.accounts.exception.ResourceNotFoundException
import tech.explore.microservice.accounts.mapper.AccountsMapper
import tech.explore.microservice.accounts.mapper.CustomerMapper
import tech.explore.microservice.accounts.repository.CardsRepository
import tech.explore.microservice.accounts.repository.CustomersRepository
import tech.explore.microservice.accounts.service.ICardsService
import java.util.*



@Service
class AccountService(
    private val accountsRepository: CardsRepository,
    private val customersRepository: CustomersRepository,
) : ICardsService {

    /**
     * @param cardsDto - CustomerDto Object
     */
    override fun createAccount(cardsDto: CardsDto?) {
        val customer: CustomerEntity = CustomerMapper.mapToCustomer(cardsDto!!, CustomerEntity())
        customersRepository.findByMobileNumber(cardsDto.mobileNumber)
            ?.ifPresent {
//                throw CustomerAlreadyExistsException(
//                    "Customer already registered with given mobileNumber "
//                            + customersDto.mobileNumber
//                )
            }

        val savedCustomer: CustomerEntity = customersRepository.save(customer)
        accountsRepository.save(createNewAccount(savedCustomer)!!)
    }


    override fun fetchAccount(mobileNumber: String?): CardsDto? {
        val customer = customersRepository.findByMobileNumber(mobileNumber)?.orElseThrow {
            ResourceNotFoundException(
                "Customer",
                "mobileNumber",
                mobileNumber
            )
        }
        val accounts= accountsRepository.findByCustomerId(customer?.customerId!!).orElseThrow {
            ResourceNotFoundException(
                "Account",
                "customerId",
                customer.customerId.toString()
            )
        }
        val customerDto: CardsDto = CustomerMapper.mapToCustomerDto(customer, CardsDto())
        customerDto.accountsDto = AccountsMapper.mapToAccountsDto(accounts, AccountsDto())
        return customerDto
    }

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    override fun updateAccount(customerDto: CardsDto?): Boolean {
        var isUpdated = false
        val accountsDto = customerDto?.accountsDto
        if (accountsDto != null) {
            var accounts = accountsRepository.findById(accountsDto.accountNumber!!).orElseThrow {
                ResourceNotFoundException(
                    "Account",
                    "AccountNumber",
                    accountsDto.accountNumber.toString()
                )
            }
            AccountsMapper.mapToAccounts(accountsDto, accounts)
            accounts = accountsRepository.save(accounts)
            val customerId = accounts.customerId
            val customer: CustomerEntity = customersRepository.findById(customerId!!).orElseThrow {
                ResourceNotFoundException(
                    "Customer",
                    "CustomerID",
                    customerId.toString()
                )
            }
            CustomerMapper.mapToCustomer(customerDto, customer)
            customersRepository.save(customer)
            isUpdated = true
        }
        return isUpdated
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    override fun deleteAccount(mobileNumber: String?): Boolean {
        val customer= customersRepository.findByMobileNumber(mobileNumber)?.orElseThrow {
            ResourceNotFoundException(
                "Customer",
                "mobileNumber",
                mobileNumber
            )
        }
        accountsRepository.deleteByCustomerId(customer?.customerId)
        customersRepository.deleteById(customer?.customerId!!)
        return true
    }


    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private fun createNewAccount(customer: CustomerEntity): CardsEntity? {
        val newAccount = CardsEntity()
        newAccount.customerId = customer.customerId!!
        val randomAccNumber: Long = 1000000000L + Random().nextInt(900000000)
        newAccount.accountNumber = randomAccNumber
        newAccount.accountType = CardConstants.SAVINGS
        newAccount.branchAddress = CardConstants.ADDRESS
        return newAccount
    }

}