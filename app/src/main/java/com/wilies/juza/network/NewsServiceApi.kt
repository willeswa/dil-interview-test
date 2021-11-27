package com.wilies.juza.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wilies.juza.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface NewsServiceApi {
    @GET("v2/top-headlines")
    suspend fun getAllNewsArticles(
        @Query("language") query: String,
        @Query("apiKey") apiKey: String
    ): EverythingNetworkContainerDTO
}


object NewsAPI {
    val retrofitService: NewsServiceApi by lazy {
        retrofit.create(NewsServiceApi::class.java)
    }
}
