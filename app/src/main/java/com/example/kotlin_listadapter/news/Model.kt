package com.example.kotlin_listadapter.news

import com.example.kotlin_listadapter.news.Articles
import com.google.gson.annotations.SerializedName
import java.util.*


data class Model (



  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Articles>

)
