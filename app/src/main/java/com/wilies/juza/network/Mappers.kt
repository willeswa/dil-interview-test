package com.wilies.juza.network

import com.wilies.juza.domain.Article

fun EverythingNetworkContainerDTO.asNewsDomainModel(): List<Article> {
    return articles.map{
        Article(
            source = it.source.name,
            articleTitle = it.title,
            articleUrl = it.articleUrl,
            articleImage = it?.articleImage,
            publishedAt =it.publishedAt
        )
    }
}