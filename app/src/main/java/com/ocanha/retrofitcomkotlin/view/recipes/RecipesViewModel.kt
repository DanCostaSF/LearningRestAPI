package com.ocanha.retrofitcomkotlin.view.recipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocanha.retrofitcomkotlin.commons.Result
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.data.usescase.RecipeUseCase
import kotlinx.coroutines.launch

class RecipesViewModel(
    private val usecase: RecipeUseCase
) : ViewModel() {
    val recipesList = MutableLiveData<List<Recipe>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllRecipes() {
        viewModelScope.launch {
            when(val response = usecase.getRecipes()) {
                is Result.Success -> {
                    recipesList.postValue(response.data ?: emptyList())
                }
                is Result.Error -> {
                    errorMessage.postValue(response.error ?: "")
                }
            }
        }
    }
}