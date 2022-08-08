package com.ocanha.retrofitcomkotlin.repositories

import com.ocanha.retrofitcomkotlin.model.Recipe
import com.ocanha.retrofitcomkotlin.rest.RetrofitInstance
import com.ocanha.retrofitcomkotlin.rest.utils.Result

class RecipeRepository {

    private val retrofitService = RetrofitInstance.getInstance()

    suspend fun saveRecipe(recipe: Recipe) = retrofitService.saveRecipe(recipe)

    suspend fun getAllRecipes() : Result<List<Recipe>> {
        val result = retrofitService.getAllRecipes()
        return if(result.isSuccessful) {
            Result.Success(result.body()?: emptyList())
        } else {
            Result.Error(result.message())
        }
    }

    companion object {
        fun getInstance() : RecipeRepository {
            return RecipeRepository()
        }
    }

}