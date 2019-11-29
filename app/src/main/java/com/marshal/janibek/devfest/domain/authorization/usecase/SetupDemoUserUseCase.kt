package com.marshal.janibek.devfest.domain.authorization.usecase

import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.authorization.error.DemoUserCreationError
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either
import com.marshal.janibek.devfest.domain.framework.usecase.BaseUseCase
import com.marshal.janibek.devfest.domain.framework.usecase.NoParams
import com.marshal.janibek.devfest.domain.repository.AccountRepository
import com.marshal.janibek.devfest.domain.repository.StatementRepository
import com.marshal.janibek.devfest.domain.repository.UserRepository

class SetupDemoUserUseCase(
    private val userRepository: UserRepository,
    private val accountRepository: AccountRepository,
    private val statementRepository: StatementRepository
) : BaseUseCase<User, NoParams>() {

    override suspend fun run(params: NoParams): Either<Failure, User> {
        val demoUser = userRepository.createDemoUser()
        val fakeStatementsResult = statementRepository.insertStatements(demoUser)
        if (fakeStatementsResult is Either.Left) {
            return Either.Left(DemoUserCreationError(fakeStatementsResult.left.exception))
        }
        val createDemoAccountResult = accountRepository.createDemoAccount(demoUser)
        if (createDemoAccountResult is Either.Left) {
            return Either.Left(DemoUserCreationError(createDemoAccountResult.left.exception))
        }
        return Either.Right(demoUser)
    }
}

