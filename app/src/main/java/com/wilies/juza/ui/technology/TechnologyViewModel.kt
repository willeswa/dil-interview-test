package com.wilies.juza.ui.technology

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.wilies.juza.MainActivity
import com.wilies.juza.data.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TechnologyViewModel(application: Application): AndroidViewModel(application) {

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)
    private val repository = NewsRepository(application)
    private val _navigating = MutableLiveData<Boolean>()
    val navigating: LiveData<Boolean> = _navigating

    init {
        coroutineScope.launch {
            repository.getAllNewsArticles("technology")
        }

        coroutineScope.launch {
            repository.getAllTechSources()
        }
    }

    fun getArticlesPublishedBy(source: String){
        coroutineScope.launch {
            repository.getAllNewsArticles( "", source)
        }
    }

    val techSources = repository.techSources
    val techArticles = repository.allArticles
    val loadingSources = repository.loadingSources
    val loadingArticles = repository.loadingArticles


    fun startNavigating(){
        _navigating.postValue(true)
    }

    fun finishNavigating(){
        _navigating.postValue(false)
    }


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }



}