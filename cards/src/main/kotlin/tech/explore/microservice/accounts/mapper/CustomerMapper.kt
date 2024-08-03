package tech.explore.microservice.accounts.mapper

import tech.explore.microservice.accounts.domain.dto.CardsDto
import tech.explore.microservice.accounts.domain.entity.CustomerEntity

class CustomerMapper {
    companion object{
        fun mapToCustomerDto(customer : CustomerEntity, customerDto : CardsDto) : CardsDto{
            customerDto.name = customer.name
            customerDto.email = customer.email
            customerDto.mobileNumber = customer.mobileNumber
            return customerDto
        }

        fun mapToCustomer(customerDto: CardsDto, customer: CustomerEntity): CustomerEntity{
            customer.name = customerDto.name
            customer.email = customerDto.email
            customer.mobileNumber = customerDto.mobileNumber
            return customer
        }
    }
}