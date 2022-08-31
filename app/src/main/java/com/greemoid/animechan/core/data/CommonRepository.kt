package com.greemoid.animechan.core.data

import com.greemoid.animechan.data.CommonDataModel

interface CommonRepository {
    suspend fun getQuote(): CommonDataModel
    suspend fun changeQuoteStatus(): CommonDataModel
    fun chooseDataSource(cached: Boolean)
}