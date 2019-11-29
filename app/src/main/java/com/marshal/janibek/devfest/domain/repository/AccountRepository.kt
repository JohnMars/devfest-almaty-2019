package com.marshal.janibek.devfest.domain.repository

import com.marshal.janibek.devfest.domain.authorization.entity.Account
import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either

interface AccountRepository {

    fun createDemoAccount(demoUser: User): Either<Failure, Account>
}
