package com.wilies.juza.adapters

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wilies.juza.domain.Article
import com.wilies.juza.network.SourceDTO

@BindingAdapter("submitNewsList")
fun submitNewsList(recyclerView: RecyclerView, newsList: List<Article>?){
    newsList?.let{
        val adapter = recyclerView.adapter as HeadlinesScreenAdapter
        adapter?.setNews(newsList)
    }
}

@BindingAdapter("submitSourcesList")
fun submitSourcesList(recyclerView: RecyclerView, sourcesList: List<SourceDTO>?){
    sourcesList?.let {
        val adapter = recyclerView.adapter as SourcesScreenAdapter
        adapter?.setSourcesList(sourcesList)
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