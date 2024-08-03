package tech.explore.microservice.cards.mapper

import tech.explore.microservice.cards.domain.dto.AccountsDto
import tech.explore.microservice.cards.domain.entity.AccountsEntity


class AccountsMapper {
    companion object {
        fun mapToAccountsDto(accounts: AccountsEntity, accountsDto: AccountsDto): AccountsDto {
            accountsDto.accountNumber = accounts.accountNumber
            accountsDto.accountType = accounts.accountType
            accountsDto.branchAddress = accounts.branchAddress
            return accountsDto
        }

        fun mapToAccounts(accountsDto: AccountsDto, accounts: AccountsEntity): AccountsEntity {
            accounts.accountNumber = accountsDto.accountNumber
            accounts.accountType = accountsDto.accountType.toString()
            accounts.branchAddress = accountsDto.branchAddress.toString()
            return accounts
        }
    }
}
