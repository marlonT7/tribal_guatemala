package com.example.marlon.prueba

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCategories {
    @GET("jokes/categories")
    suspend fun getCategories():LiveData<List<String>>

    @GET("jokes/random")
    suspend fun getCategoryDetails(@Query("category") category:String):LiveData<CategoryDetail>
}