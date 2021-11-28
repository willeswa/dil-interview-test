package com.wilies.juza.interactions

import com.wilies.juza.domain.Article
import com.wilies.juza.network.SourceDTO

class ArticleCardClickListener(val clickListener: (url: String) -> Unit){
    fun onArticleClicked(article: Article) = clickListener(article.articleUrl)
}

class SourceCardClickListener(val clickListener: (source: String) -> Unit){
    fun onSourceClicked(source: SourceDTO) = clickListener(source.name)
}