package com.greemoid.animechan.data.cache

import com.greemoid.animechan.core.data.CachedData
import com.greemoid.animechan.core.data.ChangeCommonItem
import com.greemoid.animechan.core.data.ChangeStatus
import com.greemoid.animechan.data.CommonDataModel

class BaseCachedData : CachedData {

    private var cached: ChangeCommonItem = ChangeCommonItem.Empty()

    override fun save(quote: CommonDataModel) {
        cached = quote
    }

    override fun clear() {
        cached = ChangeCommonItem.Empty()
    }

    override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
        return cached.change(changeStatus)
    }
}