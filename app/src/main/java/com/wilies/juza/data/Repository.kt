package com.wilies.juza.data

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.wilies.juza.domain.Article
import com.wilies.juza.network.*
import com.wilies.juza.utils.Utility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(private val application: Application){
    private val _everythingResponse = MutableLiveData<EverythingNetworkContainerDTO?>()
    private val _techSourcesResponse = MutableLiveData<SourcesNetworkContainerDTO>()
    private val _loadingSources = MutableLiveData(true)
    private val _loadingArticles = MutableLiveData(true)

    val loadingArticles: LiveData<Boolean> = _loadingArticles
    val loadingSources: LiveData<Boolean> = _loadingSources


    val allArticles: LiveData<List<Article?>> = Transformations.map(_everythingResponse){
        it?.asNewsDomainModel()
    }

    val techSources: LiveData<List<SourceDTO>> = Transformations.map(_techSourcesResponse){
        it.sources
    }



    suspend fun getAllNewsArticles(category: String = "", source: String = ""){
        _everythingResponse.postValue(null)
        withContext(Dispatchers.IO){
          try {
              val newsArticles = NewsAPI.retrofitService.getAllNewsArticles("en",category, source, Utility.getApiKey())
              _everythingResponse.postValue(newsArticles)
            } catch (e: Exception){
               withContext(Dispatchers.Main){
                   val toast = Toast.makeText(application, "Error! Request failed because "+e.message, Toast.LENGTH_LONG)
                   toast.show()
                   e.printStackTrace()
               }
            }
        }
        _loadingArticles.postValue(false)
    }

    suspend fun getAllTechSources(){
        withContext(Dispatchers.IO){
            try {
                val techSources = NewsAPI.retrofitService.getTechSources("technology", Utility.getApiKey())
                _techSourcesResponse.postValue(techSources)
            } catch (e: Exception){
               withContext(Dispatchers.Main){
                   val toast = Toast.makeText(application, "Error! Request failed because "+e.message, Toast.LENGTH_LONG)
                   toast.show()
               }
            }
        }
        _loadingSources.postValue(false)
    }


}
