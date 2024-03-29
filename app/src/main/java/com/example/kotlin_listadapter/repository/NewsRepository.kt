package com.example.kotlin_listadapter.repository

import com.example.kotlin_listadapter.NewsService
import com.example.kotlin_listadapter.data.Articles
import com.example.kotlin_listadapter.data.Model

import retrofit2.Response
import kotlin.collections.ArrayList

class NewsRepository {


    companion object{

        suspend fun getNews(): ArrayList<Articles>?
        {
            val newsModel: Response<Model> = RetrofitService.getInstance().create(NewsService :: class.java).getNews("in" , API.apiKey)
            return newsModel.body()?.articles
        }
    }

}