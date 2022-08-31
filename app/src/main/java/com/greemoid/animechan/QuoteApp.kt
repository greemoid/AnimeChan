package com.greemoid.animechan

import android.app.Application
import androidx.room.Room
import com.greemoid.animechan.data.BaseRepository
import com.greemoid.animechan.data.CommonSuccessMapper
import com.greemoid.animechan.data.cache.BaseCacheDataSource
import com.greemoid.animechan.data.cache.BaseCachedData
import com.greemoid.animechan.data.cache.QuoteDao
import com.greemoid.animechan.data.cache.QuoteDatabase
import com.greemoid.animechan.data.net.QuoteCloudDataSource
import com.greemoid.animechan.data.net.QuoteService
import com.greemoid.animechan.domain.BaseInteractor
import com.greemoid.animechan.domain.FailureFactory
import com.greemoid.animechan.presentation.BaseCommunication
import com.greemoid.animechan.presentation.BaseResourceManager
import com.greemoid.animechan.presentation.BaseViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteApp : Application() {

    lateinit var viewModel: BaseViewModel


    override fun onCreate() {
        super.onCreate()
        val quoteDao = QuoteDatabase.getInstance(applicationContext).getQuoteDao()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val repository =
            BaseRepository(QuoteCloudDataSource(retrofit.create(QuoteService::class.java)),
                BaseCacheDataSource(quoteDao),
                BaseCachedData())
        val interactor = BaseInteractor(repository,
            FailureFactory(BaseResourceManager(this)),
            CommonSuccessMapper())
        viewModel = BaseViewModel(interactor, BaseCommunication())
    }
}