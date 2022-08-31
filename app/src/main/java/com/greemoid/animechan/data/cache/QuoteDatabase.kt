package com.greemoid.animechan.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuoteRoomModel::class], version = 5)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao

    companion object {
        private var instance: QuoteDatabase? = null

        fun getInstance(context: Context): QuoteDatabase {
            return if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    QuoteDatabase::class.java,
                    "quote.db"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                instance as QuoteDatabase
            } else {
                instance as QuoteDatabase
            }
        }
    }
}