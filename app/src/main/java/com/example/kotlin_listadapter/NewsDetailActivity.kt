package com.example.kotlin_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlin_listadapter.news.Articles

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val newsTitle : TextView = findViewById(R.id.title)
        val newsDescription : TextView  = findViewById(R.id.desc)

        val newsDate : TextView = findViewById(R.id.date)


        val article: Articles = intent.getSerializableExtra("article") as Articles

        newsTitle.setText(article.title)
        newsDescription.setText(article.description)
        newsDate.setText(article.publishedAt)
    }
}