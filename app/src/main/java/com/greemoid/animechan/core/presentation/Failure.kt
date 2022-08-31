package com.greemoid.animechan.core.presentation

import com.greemoid.animechan.R
import com.greemoid.animechan.core.ResourceManager

interface Failure {
    fun getMessage(): String
}

class NoConnection(private val resourceManager: ResourceManager): Failure {
    override fun getMessage(): String = resourceManager.getString(R.string.no_internet)
}

class ServiceUnavailable(private val resourceManager: ResourceManager): Failure {
    override fun getMessage(): String = resourceManager.getString(R.string.service_unavailable)
}

class NoCachedData(private val resourceManager: ResourceManager): Failure {
    override fun getMessage(): String = resourceManager.getString(R.string.no_cached_data)
}

class GenericError(private val resourceManager: ResourceManager): Failure {
    override fun getMessage(): String = resourceManager.getString(R.string.generic_error)
}
