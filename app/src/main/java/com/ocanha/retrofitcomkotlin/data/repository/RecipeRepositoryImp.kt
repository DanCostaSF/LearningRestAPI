package com.ocanha.retrofitcomkotlin.data.repository

import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.commons.Result
import com.ocanha.retrofitcomkotlin.data.network.RecipeService

class RecipeRepositoryImp(
    private val service: RecipeService
) : RecipeRepository {

    override suspend fun saveRecipe(recipe: Recipe) = service.saveRecipe(recipe)

    override suspend fun getRecipes() : Result<List<Recipe>> {
        val result = service.getAllRecipes()
        return if (result.isSuccessful) {
            Result.Success(result.body() ?: emptyList())
        } else {
            Result.Error(result.message())
        }
    }

}