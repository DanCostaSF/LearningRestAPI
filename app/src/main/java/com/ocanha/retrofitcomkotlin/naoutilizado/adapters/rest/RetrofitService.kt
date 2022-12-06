package com.ocanha.retrofitcomkotlin.naoutilizado.adapters.rest

import com.ocanha.retrofitcomkotlin.data.model.Recipe
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    @GET("recipes ")
    suspend fun getAllRecipes() : Response<List<Recipe>>

    @POST("recipes")
    suspend fun saveRecipe(@Body recipe: Recipe) : Call<ResponseBody>

}