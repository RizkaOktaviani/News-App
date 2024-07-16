package com.example.newsapp.ui.api

import com.example.newsapp.ui.models.NewsResponse
import com.example.newsapp.ui.util.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.ResponseCache
import java.nio.channels.spi.AbstractSelectionKey
import java.util.Locale.IsoCountryCode

interface NewsAPI {

    @GET("v2/top head-lines")
    suspend fun  getHeadLines(
        @Query("country")
        countryCode: String ="us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY

    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun  searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY

    ): Response<NewsResponse>
}