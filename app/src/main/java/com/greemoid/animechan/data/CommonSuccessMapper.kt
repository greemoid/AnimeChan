package com.greemoid.animechan.data

import com.greemoid.animechan.core.data.CommonDataModelMapper
import com.greemoid.animechan.domain.CommonItem

class CommonSuccessMapper : CommonDataModelMapper<CommonItem.Success> {
    override fun map(
        id: Int,
        text: String,
        character: String,
        anime: String,
        cached: Boolean,
    ): CommonItem.Success {
        return CommonItem.Success(text, character, anime, cached)
    }

}