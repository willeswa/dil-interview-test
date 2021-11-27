package com.wilies.juza.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wilies.juza.databinding.HeadlinesSingleItemBinding
import com.wilies.juza.domain.Article

class HeadlinesScreenAdapter: RecyclerView.Adapter<HeadlinesScreenAdapter.HeadlineViewHolder>() {
    private var newsList: List<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
      return HeadlineViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem)
    }

    override fun getItemCount() = newsList.size

    fun setNews(news: List<Article>){
        newsList = news
        notifyDataSetChanged()
    }

    class HeadlineViewHolder(private val binding: HeadlinesSingleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: Article){
            binding.article = newsItem
        }

        companion object {
            fun from(parent: ViewGroup): HeadlineViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = HeadlinesSingleItemBinding.inflate(inflater, parent, false)
                return HeadlineViewHolder(binding)
            }
        }
    }

}