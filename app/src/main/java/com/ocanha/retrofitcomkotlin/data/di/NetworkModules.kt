package com.ocanha.retrofitcomkotlin.data.di

import com.ocanha.retrofitcomkotlin.commons.NullOnEmptyConverterFactory
import com.ocanha.retrofitcomkotlin.data.network.RecipeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules {

    private const val BASE_URL = "http://10.0.2.2:8080/"

    fun recipeService() : RecipeService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeService::class.java)
    }
}