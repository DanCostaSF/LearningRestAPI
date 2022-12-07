package com.ocanha.retrofitcomkotlin.data.usescase

import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.data.repository.RecipeRepository

class RecipeUseCaseImp(
    private val repository: RecipeRepository
): RecipeUseCase {
    override suspend fun getRecipes() = repository.getRecipes()
    override suspend fun saveRecipe(recipe: Recipe) = repository.saveRecipe(recipe)
}