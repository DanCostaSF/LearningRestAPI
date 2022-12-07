package com.ocanha.retrofitcomkotlin.data.di

import com.google.gson.GsonBuilder
import com.ocanha.retrofitcomkotlin.commons.NullOnEmptyConverterFactory
import com.ocanha.retrofitcomkotlin.data.network.RecipeService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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

//    fun recipeService() : RecipeService = OkHttpClient.Builder().addNetworkInterceptor { chain ->
//        val request = chain.request()
//        val response: okhttp3.Response = chain.proceed(request)
//        if(response.code() == 204) response.newBuilder().code(200).build()
//        else response
//    }.build().run {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(NullOnEmptyConverterFactory())
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .client(this)
//            .build()
//            .create(RecipeService::class.java)
//    }
}