package com.marshal.janibek.devfest.domain.authorization.usecase

import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either
import com.marshal.janibek.devfest.domain.framework.usecase.BaseUseCase
import com.marshal.janibek.devfest.domain.repository.UserRepository

class AuthorizationUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<User, AuthorizationUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, User> {
        return userRepository.authorize(params)
    }

    data class Params(val login: String, val password: String)
}