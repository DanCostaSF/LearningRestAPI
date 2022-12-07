package com.ocanha.retrofitcomkotlin.data.repository

import com.ocanha.retrofitcomkotlin.commons.Result
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import okhttp3.ResponseBody
import retrofit2.Call

interface RecipeRepository  {
    suspend fun getRecipes() : Result<List<Recipe>>
    suspend fun saveRecipe(recipe: Recipe): Call<ResponseBody>
}