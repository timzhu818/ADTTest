package com.example.adttest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitController {

    const val BASE_URL = "http://newsapi.org"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val requestApi: RequestApi = retrofit.create(RequestApi::class.java)
}
