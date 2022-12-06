package com.ocanha.retrofitcomkotlin.naoutilizado.adapters.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://10.0.2.2:8080/"

    private fun buildRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): RetrofitService {
        return buildRetrofit()
            .create(RetrofitService::class.java)
    }

}