package com.example.newsapp.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{

        private val retrofit by lazy {
            val logging = HtppLoggingInterceptor()
            logging.setLevel(HtppLoggingInterceptor.Level.BODY)
            val client = 0kHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()


        }
        val api by lazy{
            retrofit.create(NewsAPI::class.java)

        }
    }
}