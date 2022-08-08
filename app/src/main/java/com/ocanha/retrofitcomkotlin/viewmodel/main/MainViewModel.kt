package com.ocanha.retrofitcomkotlin.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocanha.retrofitcomkotlin.model.Recipe
import com.ocanha.retrofitcomkotlin.repositories.RecipeRepository
import com.ocanha.retrofitcomkotlin.rest.utils.Result
import kotlinx.coroutines.launch



class MainViewModel : ViewModel() {

    private val repository = RecipeRepository.getInstance()
    val recipesList = MutableLiveData<List<Recipe>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllRecipes() {
        viewModelScope.launch {
            when(val response = repository.getAllRecipes()) {
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