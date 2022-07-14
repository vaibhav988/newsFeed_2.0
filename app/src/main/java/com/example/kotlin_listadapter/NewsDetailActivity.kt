package com.example.kotlin_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlin_listadapter.databinding.ActivityNewsDetailsBinding
import com.example.kotlin_listadapter.news.Articles

class NewsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article: Articles = intent.getSerializableExtra("article") as Articles

        binding.title.setText(article.title)
        binding.desc.setText(article.description)
        binding.date.setText(article.publishedAt)
    }
}