package com.example.kotlin_listadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_listadapter.NewsListAdapter
import com.example.kotlin_listadapter.databinding.ActivityMainBinding
import com.example.kotlin_listadapter.viewmodel.NewsViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding    //creating viewbinding varible to bind with the corresponding layout file
    lateinit var newsListAdapter : NewsListAdapter   // ListAdapter
    val newsViewModel : NewsViewModel = NewsViewModel() // creating viewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newsListAdapter = NewsListAdapter(applicationContext)
        binding.recycler.layoutManager = LinearLayoutManager(this) // applying linearlayout to recyclerview
        binding.recycler.adapter = newsListAdapter // setting up the adapter



        // coroutines under lifeCycleScope
        lifecycleScope.launch {
           newsViewModel.fetchNews()
        }


        //applying observer on newlist to update the UI accordingly
        newsViewModel.newsList.observe(this , {
            newsListAdapter.submitList(it)
        })


    }

}