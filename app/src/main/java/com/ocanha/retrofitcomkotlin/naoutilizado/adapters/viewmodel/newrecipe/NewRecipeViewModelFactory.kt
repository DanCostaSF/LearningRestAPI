package com.ocanha.retrofitcomkotlin.naoutilizado.adapters.viewmodel.newrecipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ocanha.retrofitcomkotlin.naoutilizado.adapters.repositories.RecipeRepository

class NewRecipeViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewRecipeViewModel::class.java)) {
            NewRecipeViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}