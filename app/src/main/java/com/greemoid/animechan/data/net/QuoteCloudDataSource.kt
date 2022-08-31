package com.greemoid.animechan.data.net

import com.greemoid.animechan.core.data.net.CloudDataSource
import com.greemoid.animechan.core.domain.NoConnectionException
import com.greemoid.animechan.core.domain.ServiceUnavailableException
import com.greemoid.animechan.data.CommonDataModel
import java.lang.Exception
import java.net.UnknownHostException

class QuoteCloudDataSource(
    private val service: QuoteService
) : CloudDataSource {
    override suspend fun getQuote(): CommonDataModel {
        try {
            return service.getQuote().to()
        } catch (e: Exception) {
            if (e is UnknownHostException)
                throw NoConnectionException()
            else
                throw ServiceUnavailableException()
        }
    }

}