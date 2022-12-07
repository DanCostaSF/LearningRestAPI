package com.ocanha.retrofitcomkotlin.data.usescase

import com.ocanha.retrofitcomkotlin.commons.Result
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import okhttp3.ResponseBody
import retrofit2.Call

interface RecipeUseCase {
    suspend fun getRecipes(): Result<List<Recipe>>
    suspend fun saveRecipe(recipe: Recipe): Call<ResponseBody>
}