package com.example.adttest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adttest.retrofit.Article
import kotlinx.coroutines.*
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    private val _articleList = MutableLiveData<List<Article?>?>()
    private val _errorMessage = MutableLiveData<String>()

    private lateinit var job: Job

    val articleList: LiveData<List<Article?>?> = _articleList
    val errorMessage: LiveData<String> = _errorMessage

    init {
        makeApiCall()
    }

    fun makeApiCall() {
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = repository.getNews()
                withContext(Dispatchers.Main) {
                    when (response.isSuccessful) {
                        true -> _articleList.value = response.body()?.articles
                        else -> response.errorBody()?.let { _errorMessage.value = it.toString() }
                    }

                }
            } catch (exception: Exception) {
                _errorMessage.postValue(exception.toString())
            }
        }
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}