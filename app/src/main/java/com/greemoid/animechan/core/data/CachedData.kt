package com.greemoid.animechan.core.data

import com.greemoid.animechan.data.CommonDataModel

interface CachedData : ChangeCommonItem {
    fun save(quote: CommonDataModel)
    fun clear()
}