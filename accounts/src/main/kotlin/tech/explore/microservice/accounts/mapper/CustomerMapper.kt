package tech.explore.microservice.accounts.mapper

import tech.explore.microservice.accounts.domain.dto.CustomersDto
import tech.explore.microservice.accounts.domain.entity.CustomerEntity

class CustomerMapper {
    companion object{
        fun mapToCustomerDto(customer : CustomerEntity, customerDto : CustomersDto) : CustomersDto{
            customerDto.name = customer.name
            customerDto.email = customer.email
            customerDto.mobileNumber = customer.mobileNumber
            return customerDto
        }

        fun mapToCustomer(customerDto: CustomersDto, customer: CustomerEntity): CustomerEntity{
            customer.name = customerDto.name
            customer.email = customerDto.email
            customer.mobileNumber = customerDto.mobileNumber
            return customer
        }
    }
}