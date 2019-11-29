package com.marshal.janibek.devfest.presentation.login

import androidx.lifecycle.ViewModel
import com.marshal.janibek.devfest.domain.authorization.entity.User
import com.marshal.janibek.devfest.domain.authorization.error.UserNotFound
import com.marshal.janibek.devfest.domain.authorization.usecase.AuthorizationUseCase
import com.marshal.janibek.devfest.domain.authorization.usecase.SetupDemoUserUseCase
import com.marshal.janibek.devfest.domain.framework.exception.Failure
import com.marshal.janibek.devfest.domain.framework.usecase.NoParams
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(
    private val authorizationUseCase: AuthorizationUseCase,
    private val setupDemoUserUseCase: SetupDemoUserUseCase
) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private var login: String = ""
    private var password: String = ""

    fun onLoginClicked() {
        val params = AuthorizationUseCase.Params(login, password)
        authorizationUseCase(this, params) { it.either(::handleAuthorizationError, ::onAuthorized) }
    }

    private fun handleAuthorizationError(authorizationFailure: Failure) {

    }

    private fun onAuthorized(user: User) {
        // TODO
    }

    private fun onDemoUserCreated(user: User) {
        // TODO
    }

    private fun onSetupDemoUserFailed(failure: Failure) {
        // TODO
    }
}