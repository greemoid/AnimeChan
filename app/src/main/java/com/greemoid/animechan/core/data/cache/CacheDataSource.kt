package com.greemoid.animechan.core.data.cache

import com.greemoid.animechan.core.data.ChangeStatus
import com.greemoid.animechan.core.data.DataFetcher
import com.greemoid.animechan.data.CommonDataModel

interface CacheDataSource: DataFetcher, ChangeStatus {
    override suspend fun getQuote(): CommonDataModel
}