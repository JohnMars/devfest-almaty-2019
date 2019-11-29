package com.marshal.janibek.devfest.domain.authorization.usecase

import com.marshal.janibek.devfest.domain.authorization.entity.Statement
import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either
import com.marshal.janibek.devfest.domain.repository.StatementRepository

class FakeStatementRepository(
    private val statements: List<Statement> = emptyList()
) : StatementRepository {

    override suspend fun insertStatements(demoUser: User): Either<Failure, List<Statement>> {
        return Either.Right(statements)
    }
}