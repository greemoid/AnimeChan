package com.greemoid.animechan.data

import com.greemoid.animechan.core.data.ChangeCommonItem
import com.greemoid.animechan.core.data.ChangeStatus
import com.greemoid.animechan.core.data.CommonDataModelMapper
import com.greemoid.animechan.core.data.Mapper
import com.greemoid.animechan.data.cache.QuoteRoomModel

data class CommonDataModel(
    private val id: Int,
    private val anime: String,
    private val character: String,
    private val quote: String,
    private val cached: Boolean = false,
) : ChangeCommonItem, Mapper<QuoteRoomModel> {

    fun <T> map(mapper: CommonDataModelMapper<T>): T {
        return mapper.map(id, quote, character, anime, cached)
    }

    override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
        return changeStatus.addOrRemove(this)
    }

    fun title(): String = quote

    override fun to(): QuoteRoomModel {
        return QuoteRoomModel(id, quote, character, anime, true)
    }

}