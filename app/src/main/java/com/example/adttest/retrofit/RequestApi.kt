package com.example.adttest.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface RequestApi {

    @GET("/v2/top-headlines?country=us&apiKey=1437be957ba74f9e93cf1688a28a05ac")
    suspend fun getBody(): Response<NewsResponse>
}
