package com.marshal.janibek.devfest.domain.repository

import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.authorization.usecase.AuthorizationUseCase
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.model.Either

interface UserRepository {

    suspend fun authorize(params: AuthorizationUseCase.Params): Either<Failure, User>

    suspend fun createDemoUser(): User
}
