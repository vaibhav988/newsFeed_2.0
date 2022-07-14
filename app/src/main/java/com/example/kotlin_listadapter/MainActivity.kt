package com.example.kotlin_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_listadapter.news.Articles
import com.example.kotlin_listadapter.news.Model
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRecyclerView  = findViewById<RecyclerView>(R.id.recycler)
        newsRecyclerView.layoutManager = LinearLayoutManager(this)

        val listArticles : ArrayList<Articles> = ArrayList()  // for storing the data fetched from API
        val newsListAdapter  = NewsListAdapter(applicationContext) // ListAdapter

         newsRecyclerView.adapter = newsListAdapter

        val newsServiceInstance = Retrofit.Builder().baseUrl(API.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build().create(newsService::class.java)
                  // service to interact with the API call


        // coroutines under lifeCycleScope
        lifecycleScope.launch {
            val newsModel: Response<Model> = newsServiceInstance.getNews("in" , API.apiKey)
            try {

                for (article in newsModel.body()?.articles!!) {

                    listArticles.add(article)

                }

            }
            catch (e : NullPointerException)
            {
                Log.d("Exception" , e.message.toString())
            }

            newsListAdapter.submitList(listArticles)

        }

    }

}