package com.greemoid.animechan.domain

import com.greemoid.animechan.core.ResourceManager
import com.greemoid.animechan.core.domain.FailureHandler
import com.greemoid.animechan.core.domain.NoCachedDataException
import com.greemoid.animechan.core.domain.NoConnectionException
import com.greemoid.animechan.core.domain.ServiceUnavailableException
import com.greemoid.animechan.core.presentation.*

class FailureFactory(private val resourceManager: ResourceManager) : FailureHandler {
    override fun handle(e: Exception): Failure {
        return when (e) {
            is NoConnectionException -> NoConnection(resourceManager)
            is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
            is NoCachedDataException -> NoCachedData(resourceManager)
            else -> GenericError(resourceManager)
        }
    }
}