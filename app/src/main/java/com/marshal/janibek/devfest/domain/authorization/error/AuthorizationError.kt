package com.marshal.janibek.devfest.domain.authorization.error

import com.marshal.janibek.devfest.domain.framework.exception.Failure
import java.lang.Exception

class AuthorizationError(
    exception: Exception
) : Failure.FeatureFailure(exception)