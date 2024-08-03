package tech.explore.microservice.cards.service.impl

import org.springframework.stereotype.Service
import tech.explore.microservice.cards.domain.constants.AccountsConstants
import tech.explore.microservice.cards.domain.dto.AccountsDto
import tech.explore.microservice.cards.domain.dto.CustomersDto
import tech.explore.microservice.cards.domain.entity.AccountsEntity
import tech.explore.microservice.cards.domain.entity.CustomerEntity
import tech.explore.microservice.cards.exception.ResourceNotFoundException
import tech.explore.microservice.cards.mapper.AccountsMapper
import tech.explore.microservice.cards.mapper.CustomerMapper
import tech.explore.microservice.cards.repository.AccountsRepository
import tech.explore.microservice.cards.repository.CustomersRepository
import tech.explore.microservice.cards.service.IAccountService
import java.util.*



@Service
class AccountService(
    private val accountsRepository: AccountsRepository,
    private val customersRepository: CustomersRepository,
) : IAccountService {

    /**
     * @param customersDto - CustomerDto Object
     */
    override fun createAccount(customersDto: CustomersDto?) {
        val customer: CustomerEntity = CustomerMapper.mapToCustomer(customersDto!!, CustomerEntity())
        customersRepository.findByMobileNumber(customersDto.mobileNumber)
            ?.ifPresent {
//                throw CustomerAlreadyExistsException(
//                    "Customer already registered with given mobileNumber "
//                            + customersDto.mobileNumber
//                )
            }

        val savedCustomer: CustomerEntity = customersRepository.save(customer)
        accountsRepository.save(createNewAccount(savedCustomer)!!)
    }


    override fun fetchAccount(mobileNumber: String?): CustomersDto? {
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
        val customerDto: CustomersDto = CustomerMapper.mapToCustomerDto(customer, CustomersDto())
        customerDto.accountsDto = AccountsMapper.mapToAccountsDto(accounts, AccountsDto())
        return customerDto
    }

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    override fun updateAccount(customerDto: CustomersDto?): Boolean {
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
    private fun createNewAccount(customer: CustomerEntity): AccountsEntity? {
        val newAccount = AccountsEntity()
        newAccount.customerId = customer.customerId!!
        val randomAccNumber: Long = 1000000000L + Random().nextInt(900000000)
        newAccount.accountNumber = randomAccNumber
        newAccount.accountType = AccountsConstants.SAVINGS
        newAccount.branchAddress = AccountsConstants.ADDRESS
        return newAccount
    }

}