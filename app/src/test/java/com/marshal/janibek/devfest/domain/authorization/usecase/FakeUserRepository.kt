package com.marshal.janibek.devfest.domain.authorization.usecase

import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either
import com.marshal.janibek.devfest.domain.repository.UserRepository

class FakeUserRepository(
    private val user: User = User(1, "Doge")
) : UserRepository {

    override suspend fun authorize(params: AuthorizationUseCase.Params): Either<Failure, User> {
        return Either.Right(user)
    }

    override suspend fun createDemoUser(): User {
        return user
    }
}