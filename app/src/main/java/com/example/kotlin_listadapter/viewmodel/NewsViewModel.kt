package com.example.kotlin_listadapter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_listadapter.data.Articles
import com.example.kotlin_listadapter.repository.NewsRepository

class NewsViewModel : ViewModel() {

    val newsList = MutableLiveData<List<Articles>>()
    suspend fun fetchNews()
    {
         val list = NewsRepository.getNews()
         newsList.postValue(list)
    }

}