package com.wilies.juza.domain

data class Article(
    val source: String,
    val articleTitle: String,
    val articleUrl:String,
    val articleImage: String?,
    val publishedAt: String)
