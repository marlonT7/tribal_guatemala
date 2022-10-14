package com.example.marlon.prueba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import androidx.lifecycle.liveData
import javax.inject.Inject


class MainViewModel @Inject constructor(
    val coroutineDispatcher: CoroutineDispatcher,
    val apiCategories: ApiCategories
) : ViewModel() {

    fun getCategories() = liveData(viewModelScope.coroutineContext + coroutineDispatcher) {
        emit(apiCategories.getCategories())
    }
}