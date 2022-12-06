package com.ocanha.retrofitcomkotlin.presentation.newrecipes

import android.os.Bundle
import android.view.View
import com.ocanha.retrofitcomkotlin.R
import com.ocanha.retrofitcomkotlin.commons.BaseFragment
import com.ocanha.retrofitcomkotlin.databinding.FragmentNewRecipesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewRecipesFragment : BaseFragment<FragmentNewRecipesBinding>(
    R.layout.fragment_new_recipes
){

    private val vm: NewRecipesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setupViewModel() {
        binding.vm = vm
    }

    override fun setupObservers() {

    }
}