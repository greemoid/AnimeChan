package com.greemoid.animechan.domain

import android.util.Log
import com.greemoid.animechan.core.data.CommonDataModelMapper
import com.greemoid.animechan.core.data.CommonRepository
import com.greemoid.animechan.core.domain.CommonInteractor
import com.greemoid.animechan.core.domain.FailureHandler

class BaseInteractor(
    private val repository: CommonRepository,
    private val failureHandler: FailureHandler,
    private val mapper: CommonDataModelMapper<CommonItem.Success>,
) : CommonInteractor {
    override suspend fun getQuote(): CommonItem {
        return try {
            val quote = repository.getQuote().map(mapper)
            CommonItem.Success(quote.quote, quote.character, quote.anime, false)
        } catch (e: Exception) {
            Log.d("REPO", e.toString())
            CommonItem.Failed(failureHandler.handle(e))
        }
    }

    override suspend fun changeQuoteStatus(): CommonItem {
        return try {
            repository.changeQuoteStatus().map(mapper)
        } catch (e: Exception) {
            Log.d("REPO", e.toString())
            CommonItem.Failed(failureHandler.handle(e))
        }
    }

    override fun getFavorites(favorites: Boolean) {
        repository.chooseDataSource(favorites)
    }
}