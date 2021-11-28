package com.wilies.juza.network

import com.wilies.juza.domain.Article

fun EverythingNetworkContainerDTO.asNewsDomainModel(): List<Article?> {
    return articles.map{
        it.articleUrl?.let { it1 ->
            Article(
                source = it.source.name,
                articleTitle = it.title,
                articleUrl = it1,
                articleImage = it?.articleImage,
                publishedAt =it.publishedAt
            )
        }
    }
}