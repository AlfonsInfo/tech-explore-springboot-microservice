package tech.explore.microservice.accounts.mapper

import tech.explore.microservice.accounts.domain.dto.AccountsDto
import tech.explore.microservice.accounts.domain.entity.CardsEntity


class AccountsMapper {
    companion object {
        fun mapToAccountsDto(accounts: CardsEntity, accountsDto: AccountsDto): AccountsDto {
            accountsDto.accountNumber = accounts.accountNumber
            accountsDto.accountType = accounts.accountType
            accountsDto.branchAddress = accounts.branchAddress
            return accountsDto
        }

        fun mapToAccounts(accountsDto: AccountsDto, accounts: CardsEntity): CardsEntity {
            accounts.accountNumber = accountsDto.accountNumber
            accounts.accountType = accountsDto.accountType.toString()
            accounts.branchAddress = accountsDto.branchAddress.toString()
            return accounts
        }
    }
}
