package com.ocanha.retrofitcomkotlin.repositories

import android.util.Log
import com.ocanha.retrofitcomkotlin.model.Recipe
import com.ocanha.retrofitcomkotlin.rest.RetrofitService

class RecipeRepository(private val retrofitService: RetrofitService) {


    fun saveRecipe(recipe: Recipe) = retrofitService.saveRecipe(recipe)

    fun getAllRecipes() = retrofitService.getAllRecipes()

}