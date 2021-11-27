package com.wilies.juza.ui.headlines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wilies.juza.data.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)
    private val repository = NewsRepository()

    init {
        coroutineScope.launch {
            repository.getAllNewsArticles()
        }
    }

    val allNewsArticles = repository.allArticles
}