package com.example.kotlin_listadapter.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(API.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}