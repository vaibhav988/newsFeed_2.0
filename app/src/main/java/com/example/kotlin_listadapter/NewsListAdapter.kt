package com.example.kotlin_listadapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_listadapter.news.Articles

class NewsListAdapter(val context: Context) : ListAdapter<Articles, NewsListAdapter.ItemViewholder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {

        val view : View  = LayoutInflater.from(parent.context).inflate(R.layout.news_item , parent , false)
        return  ItemViewholder(view)

    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener(
            {

                val intent = Intent( context ,  NewsDetailActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("article" ,getItem(position))

                context.startActivity(intent)

            }
        )
    }

    class ItemViewholder(view : View) : RecyclerView.ViewHolder(view) {

         val textTitle = view.findViewById<TextView>(R.id.newsTitle)

         fun bind(item: Articles){

               textTitle.setText(item.title)

         }

    }


}

class DiffCallback : DiffUtil.ItemCallback<Articles>() {
    override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem.source?.id == newItem.source?.id
    }

    override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem == newItem
    }
}
