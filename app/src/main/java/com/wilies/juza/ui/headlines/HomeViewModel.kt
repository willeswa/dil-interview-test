package com.wilies.juza.ui.headlines

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wilies.juza.data.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)
    private val repository = NewsRepository(application)

    init {
        coroutineScope.launch {
            repository.getAllNewsArticles()
        }
    }

    val allNewsArticles = repository.allArticles
    val loadingArticles = repository.loadingArticles

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}