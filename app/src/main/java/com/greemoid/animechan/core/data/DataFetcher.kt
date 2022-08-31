package com.greemoid.animechan.core.data

import com.greemoid.animechan.data.CommonDataModel

interface DataFetcher {
    suspend fun getQuote(): CommonDataModel
}