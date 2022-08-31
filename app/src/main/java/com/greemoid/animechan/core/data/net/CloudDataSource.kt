package com.greemoid.animechan.core.data.net

import com.greemoid.animechan.core.data.DataFetcher
import com.greemoid.animechan.data.CommonDataModel

interface CloudDataSource : DataFetcher {
    override suspend fun getQuote(): CommonDataModel
}