package tech.explore.microservice.loans.service

import tech.explore.microservice.loans.domain.dto.CustomersDto

interface IAccountService {
    /**
     *
     * @param customersDto - CustomerDto Object
     */
    fun createAccount(customersDto: CustomersDto?)

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    fun fetchAccount(mobileNumber: String?): CustomersDto?

    /**
     *
     * @param customerDto - CustomersDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    fun updateAccount(customerDto: CustomersDto?): Boolean

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    fun deleteAccount(mobileNumber: String?): Boolean
}