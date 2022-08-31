package com.greemoid.animechan.data.cache

import com.greemoid.animechan.core.data.cache.CacheDataSource
import com.greemoid.animechan.data.CommonDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseCacheDataSource(private val quoteDao: QuoteDao) : CacheDataSource {
    private var title: String = ""

    override suspend fun getQuote(): CommonDataModel {
        val model = quoteDao.getAllQuotes().random().to()
        title = model.title()
        return model
    }

    override suspend fun addOrRemove(model: CommonDataModel): CommonDataModel {
        withContext(Dispatchers.IO) {
            if(model.title() == title) {
                quoteDao.deleteQuote(title)
            } else {
                quoteDao.insertQuote(model.to())
            }
        }
        return model
    }
}