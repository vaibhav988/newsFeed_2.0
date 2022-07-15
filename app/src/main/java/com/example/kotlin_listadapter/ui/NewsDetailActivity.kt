package com.example.kotlin_listadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_listadapter.databinding.ActivityNewsDetailsBinding
import com.example.kotlin_listadapter.data.Articles

class NewsDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsDetailsBinding
    lateinit var article: Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

         article = intent.getSerializableExtra("article") as Articles

        binding.title.setText(article.title)
        binding.desc.setText(article.description)
        binding.date.setText(article.publishedAt)
    }
}