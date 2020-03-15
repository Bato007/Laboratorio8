package com.example.gitrepository.mainfragment

import android.text.BoringLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitrepository.networklayer.GitHubApi
import com.example.gitrepository.networklayer.GitProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    // El nombre del cuate de github
    private var _gitHubUsername = MutableLiveData<String>()
    val gitHubUsername: LiveData<String>
        get() = _gitHubUsername

    // La imagen del repositorio
    private var _property = MutableLiveData<GitProperty>()
    val property: LiveData<GitProperty>
        get() = _property

    // Variables
    private val _flag = MutableLiveData<Boolean>()
    val flag: Boolean?
        get() = _flag.value

    // Coroutines
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private fun getMarsRealEstateProperties(){
        coroutineScope.launch {
            val getPropertiesDeferred = GitHubApi.retrofitService.getProperties()

            try {
                var listResults = getPropertiesDeferred.await()
                _property.value = listResults[1]
                _flag.value = true
            } catch (t:Throwable){
                _flag.value = false
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}