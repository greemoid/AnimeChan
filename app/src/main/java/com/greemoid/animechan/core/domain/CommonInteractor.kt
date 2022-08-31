package com.greemoid.animechan.core.domain

import com.greemoid.animechan.domain.CommonItem


interface CommonInteractor {
    suspend fun getQuote(): CommonItem
    suspend fun changeQuoteStatus(): CommonItem
    fun getFavorites(favorites: Boolean)
}