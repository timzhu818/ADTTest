package com.example.adttest

import com.example.adttest.retrofit.RetrofitController

class MainRepository {

    private var client = RetrofitController.requestApi

    suspend fun getNews() = client.getBody()
}