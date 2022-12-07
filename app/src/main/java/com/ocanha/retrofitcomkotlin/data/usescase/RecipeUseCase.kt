package com.ocanha.retrofitcomkotlin.data.usescase

import com.ocanha.retrofitcomkotlin.commons.Result
import com.ocanha.retrofitcomkotlin.data.model.Recipe

interface RecipeUseCase {
    suspend fun getRecipes(): Result<List<Recipe>>
    suspend fun saveRecipe(recipe: Recipe): Unit
}