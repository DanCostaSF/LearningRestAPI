package com.ocanha.retrofitcomkotlin.viewmodel.newrecipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ocanha.retrofitcomkotlin.repositories.RecipeRepository

class NewRecipeViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewRecipeViewModel::class.java)) {
            NewRecipeViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}