package com.greemoid.animechan.data.net

import com.google.gson.annotations.SerializedName
import com.greemoid.animechan.core.data.Mapper
import com.greemoid.animechan.data.CommonDataModel

data class QuoteServerModel(
    @SerializedName("anime")
    private val anime: String,
    @SerializedName("character")
    private val character: String,
    @SerializedName("quote")
    private val quote: String,
) : Mapper<CommonDataModel> {

    override fun to(): CommonDataModel =
        CommonDataModel(Math.random().toInt(), anime, character, quote)

}