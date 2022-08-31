package com.greemoid.animechan.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.greemoid.animechan.core.data.Mapper
import com.greemoid.animechan.data.CommonDataModel

@Entity(tableName = "quote_anime_table")
class QuoteRoomModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val quote: String,
    @ColumnInfo val character: String,
    @ColumnInfo val anime: String,
    @ColumnInfo val cached: Boolean,
) : Mapper<CommonDataModel> {
    fun title(): String = quote
    override fun to(): CommonDataModel {
        return CommonDataModel(id, anime, character, quote, false)
    }

}