package com.marshal.janibek.devfest.domain.authorization.error

import com.marshal.janibek.devfest.domain.framework.exception.Failure
import java.lang.Exception

class DemoUserCreationError(
    cause: Exception
) : Failure.FeatureFailure(cause)