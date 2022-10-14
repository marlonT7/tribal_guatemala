package com.example.marlon.prueba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import androidx.lifecycle.liveData
import javax.inject.Inject


class DetailViewModel @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val apiCategories: ApiCategories
) : ViewModel() {

    fun getCategoryDetails(category: String) =
        liveData(viewModelScope.coroutineContext + coroutineDispatcher) {
            emit(apiCategories.getCategoryDetails(category))
        }
}