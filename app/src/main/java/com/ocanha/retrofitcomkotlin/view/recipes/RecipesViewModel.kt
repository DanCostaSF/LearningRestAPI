package com.ocanha.retrofitcomkotlin.view.recipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocanha.retrofitcomkotlin.commons.Result
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.data.usescase.RecipeUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RecipesViewModel(
    private val usecase: RecipeUseCase
) : ViewModel() {
    val recipesList = MutableLiveData<List<Recipe>>()
    val errorMessage = MutableLiveData<String>()

    val imageAndTextNoRecipes = MutableLiveData(false)
    val recyclerVisibility = MutableLiveData(false)
    val progressBar = MutableLiveData(false)

    val navigateToNewRecipe = MutableLiveData(false)

    fun navigateOn() {
        navigateToNewRecipe.value = true
    }

    fun navigateOff() {
        navigateToNewRecipe.value = false
    }

    fun getAllRecipes() {
        startVisibility()
        viewModelScope.launch {
            when(val response = usecase.getRecipes()) {
                is Result.Success -> {
                    recipesList.postValue(response.data ?: emptyList())
                    progressBar.value = false
                    recyclerVisibility.value = true
                }
                is Result.Error -> {
                    errorMessage.postValue(response.error ?: "")
                    imageAndTextNoRecipes.value = true
                    recyclerVisibility.value = false
                    progressBar.value = false
                }
            }
        }
    }

    private fun startVisibility() {
        progressBar.value = true
        imageAndTextNoRecipes.value = false
        recyclerVisibility.value = false
    }
}