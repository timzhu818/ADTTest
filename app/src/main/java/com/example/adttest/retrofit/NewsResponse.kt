package com.example.adttest.retrofit

data class NewsResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: List<Article?>?
)
