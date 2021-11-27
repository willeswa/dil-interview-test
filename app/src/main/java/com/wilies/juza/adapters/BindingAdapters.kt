package com.wilies.juza.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wilies.juza.domain.Article

@BindingAdapter("submitNewsList")
fun submitNewsList(recyclerView: RecyclerView, newsList: List<Article>?){
    newsList?.let{
        val adapter = recyclerView.adapter as HeadlinesScreenAdapter
        adapter?.setNews(newsList)
    }
}

@BindingAdapter("setNewsImage")
fun setNewsImage(view: ImageView, url: String?){
    url?.let {
        Glide.with(view.context)
            .load(url)
            .into(view)
        }
}

@BindingAdapter("publishedThisLongAgo")
fun publishToLongAgo(view: TextView, time: String){

}