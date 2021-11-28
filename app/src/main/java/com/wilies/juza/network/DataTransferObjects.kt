package com.wilies.juza.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EverythingNetworkContainerDTO(
    val status: String,
    val articles: List<ArticleDTO>)

@JsonClass(generateAdapter = true)
data class ArticleDTO(
    val source: SourceDTO,
    val title: String,
    @Json(name = "url") val articleUrl:String?,
    @Json(name ="urlToImage") val articleImage: String?,
    val publishedAt: String)

@JsonClass(generateAdapter = true)
data class SourceDTO(
    val name: String,
    val description: String?,
    val url: String?)


@JsonClass(generateAdapter = true)
data class SourcesNetworkContainerDTO(
    val status: String,
    val sources: List<SourceDTO>
)