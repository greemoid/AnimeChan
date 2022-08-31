package com.greemoid.animechan.data

import android.util.Log
import com.greemoid.animechan.core.data.CachedData
import com.greemoid.animechan.core.data.CommonRepository
import com.greemoid.animechan.core.data.DataFetcher
import com.greemoid.animechan.core.data.cache.CacheDataSource
import com.greemoid.animechan.core.data.net.CloudDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class BaseRepository(
    private val cloudDataSource: CloudDataSource,
    private val cacheDataSource: CacheDataSource,
    private val cachedQuote: CachedData,
) : CommonRepository {

    private var currentDataSource: DataFetcher = cloudDataSource

    override suspend fun getQuote(): CommonDataModel = withContext(Dispatchers.IO) {
        try {
            val quote = currentDataSource.getQuote()
            cachedQuote.save(quote)
            return@withContext quote
        } catch (e: Exception) {
            cachedQuote.clear()
            throw e
        }
    }

    override suspend fun changeQuoteStatus(): CommonDataModel {
        return cachedQuote.change(cacheDataSource)
    }

    override fun chooseDataSource(cached: Boolean) {
        currentDataSource = if (cached) cacheDataSource else cloudDataSource
    }
}