package com.greemoid.animechan.data.net

import retrofit2.http.GET

interface QuoteService {
    @GET("https://animechan.vercel.app/api/random")
    suspend fun getQuote(): QuoteServerModel
}