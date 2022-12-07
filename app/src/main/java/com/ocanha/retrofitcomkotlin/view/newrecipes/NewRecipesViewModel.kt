package com.ocanha.retrofitcomkotlin.view.newrecipes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.data.usescase.RecipeUseCase
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewRecipesViewModel(
    private val usecase: RecipeUseCase
) : ViewModel() {
    val status = MutableLiveData<Boolean>()

    fun saveRecipe(recipe: Recipe) {
        viewModelScope.launch {
            try {
                usecase.saveRecipe(recipe)
                status.value = true
            } catch (e: Exception) {
                status.value = false
                Log.i("error newrecipesvm", "$e")
            }
        }
    }
}