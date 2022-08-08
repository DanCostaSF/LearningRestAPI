package com.ocanha.retrofitcomkotlin.rest

import com.ocanha.retrofitcomkotlin.model.Recipe
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    @GET("recipes")
    suspend fun getAllRecipes() : Response<List<Recipe>>

    @POST("recipes")
    suspend fun saveRecipe(@Body recipe: Recipe) : Call<ResponseBody>


}