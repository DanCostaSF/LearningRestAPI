package com.ocanha.retrofitcomkotlin.data.network.di

import com.ocanha.retrofitcomkotlin.data.di.NetworkModules
import com.ocanha.retrofitcomkotlin.data.repository.RecipeRepositoryImp
import com.ocanha.retrofitcomkotlin.data.repository.RecipeRepository
import com.ocanha.retrofitcomkotlin.data.usescase.RecipeUseCase
import com.ocanha.retrofitcomkotlin.data.usescase.RecipeUseCaseImp
import com.ocanha.retrofitcomkotlin.view.newrecipes.NewRecipesViewModel
import com.ocanha.retrofitcomkotlin.view.recipes.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object RecipesDi {

    val module = module {
        viewModel {
            RecipesViewModel(
                usecase = get()
            )
        }
        viewModel {
            NewRecipesViewModel(
                usecase = get()
            )
        }

        factory {
            NetworkModules
        }

        factory<RecipeUseCase> {
            RecipeUseCaseImp(
                repository = get()
            )
        }

        factory<RecipeRepository> {
            RecipeRepositoryImp(
                service = NetworkModules.recipeService()
            )
        }
    }
}