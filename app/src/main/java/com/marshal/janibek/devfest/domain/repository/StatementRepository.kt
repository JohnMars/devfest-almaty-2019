package com.marshal.janibek.devfest.domain.repository

import com.marshal.janibek.devfest.domain.authorization.entity.Statement
import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either

interface StatementRepository {

    suspend fun insertStatements(demoUser: User): Either<Failure, List<Statement>>
}
