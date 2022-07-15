package com.example.kotlin_listadapter

import com.example.kotlin_listadapter.data.Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface newsService {

     @GET("top-headlines")
     suspend fun getNews(@Query("country") country : String , @Query("apiKey") apiKey : String):Response<Model>


}