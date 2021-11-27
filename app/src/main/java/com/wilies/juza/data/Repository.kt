package com.wilies.juza.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.wilies.juza.domain.Article
import com.wilies.juza.network.EverythingNetworkContainerDTO
import com.wilies.juza.network.NewsAPI
import com.wilies.juza.network.asNewsDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(){
    private val everythingResponse = MutableLiveData<EverythingNetworkContainerDTO>()

    val allArticles: LiveData<List<Article>> = Transformations.map(everythingResponse){
        it.asNewsDomainModel()
    }

    suspend fun getAllNewsArticles(){
        withContext(Dispatchers.IO){
            val newsArticles = NewsAPI.retrofitService.getAllNewsArticles("en","")
            everythingResponse.postValue(newsArticles)
        }
    }

}
