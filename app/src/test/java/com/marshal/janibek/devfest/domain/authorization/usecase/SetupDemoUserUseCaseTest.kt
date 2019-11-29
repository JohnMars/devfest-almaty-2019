package com.marshal.janibek.devfest.domain.authorization.usecase

import com.marshal.janibek.devfest.domain.framework.usecase.NoParams
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class SetupDemoUserUseCaseTest {

    private val setupDemoUserUseCase = SetupDemoUserUseCase(
        userRepository = FakeUserRepository(),
        accountRepository = FakeAccountRepository(),
        statementRepository = FakeStatementRepository()
    )

    @Test
    fun `check that setup demo user runs successfully`() = runBlocking {
        setupDemoUserUseCase(this, NoParams) {
            assertThat(it.isRight, `is`(true))
        }
    }
}