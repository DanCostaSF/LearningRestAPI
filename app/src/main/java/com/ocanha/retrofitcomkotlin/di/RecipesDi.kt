package com.ocanha.retrofitcomkotlin.di

import com.ocanha.retrofitcomkotlin.presentation.newrecipes.NewRecipesViewModel
import com.ocanha.retrofitcomkotlin.presentation.recipes.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object RecipesDi {

    val module = module {
        viewModel {
            RecipesViewModel()
        }
        viewModel {
           NewRecipesViewModel()
        }
    }
}