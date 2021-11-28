package com.wilies.juza.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wilies.juza.databinding.HeadlinesSingleItemBinding
import com.wilies.juza.domain.Article
import com.wilies.juza.interactions.ArticleCardClickListener

class HeadlinesScreenAdapter(private val clickListener: ArticleCardClickListener):
    RecyclerView.Adapter<HeadlinesScreenAdapter.HeadlineViewHolder>() {
    private var newsList: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
      return HeadlineViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem, clickListener)
    }

    override fun getItemCount() = newsList.size

    fun setNews(news: List<Article>){
        newsList = news
        notifyDataSetChanged()
    }

    class HeadlineViewHolder(private val binding: HeadlinesSingleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: Article, clickListener: ArticleCardClickListener){
            binding.clickListener = clickListener
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