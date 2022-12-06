package com.ocanha.retrofitcomkotlin.naoutilizado.adapters.viewmodel.newrecipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.naoutilizado.adapters.repositories.RecipeRepository
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewRecipeViewModel : ViewModel() {

    private val repository = RecipeRepository.getInstance()
    val status = MutableLiveData<Boolean>()

    fun saveRecipe(recipe: Recipe) {
        viewModelScope.launch {
            val request = repository.saveRecipe(recipe)
            request.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    if (response.code() == 200) {
                        status.postValue(true)
                    } else {
                        status.postValue(false)
                    }

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    status.postValue(false)
                }

            })
        }

    }



}