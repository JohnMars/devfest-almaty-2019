package com.marshal.janibek.devfest.domain.authorization.usecase

import com.marshal.janibek.devfest.domain.authorization.entity.Account
import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either
import com.marshal.janibek.devfest.domain.repository.AccountRepository

class FakeAccountRepository(
    private val account: Account = Account(1)
) : AccountRepository {

    override fun createDemoAccount(demoUser: User): Either<Failure, Account> {
        return Either.Right(account)
    }
}
