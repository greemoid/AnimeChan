package com.greemoid.animechan.data.cache

import androidx.room.*

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote_anime_table")
    fun getAllQuotes(): List<QuoteRoomModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: QuoteRoomModel)

    @Query("DELETE FROM quote_anime_table WHERE quote = :title")
    suspend fun deleteQuote(title: String)
}