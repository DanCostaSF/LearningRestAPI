package com.ocanha.retrofitcomkotlin.data.network

import com.ocanha.retrofitcomkotlin.data.model.Recipe
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RecipeService {

    @GET("recipes ")
    suspend fun getAllRecipes() : Response<List<Recipe>>

    @POST("recipes")
    suspend fun saveRecipe(@Body recipe: Recipe) : Unit

}