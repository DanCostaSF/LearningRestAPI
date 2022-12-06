package com.ocanha.retrofitcomkotlin.presentation.recipes

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocanha.retrofitcomkotlin.R
import com.ocanha.retrofitcomkotlin.commons.BaseFragment
import com.ocanha.retrofitcomkotlin.commons.navTo
import com.ocanha.retrofitcomkotlin.databinding.FragmentRecipesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RecipesFragment : BaseFragment<FragmentRecipesBinding>(
    R.layout.fragment_recipes
) {

    private val vm: RecipesViewModel by viewModel()
    private val adapter = RecipesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFab()
        setupRecycler()
    }

    private fun setupFab() = binding.apply {
        fabNewRecipe.setOnClickListener {
            navTo(RecipesFragmentDirections.actionRecipesFragmentToFragmentNewRecipes())
        }
    }

    private fun setupRecycler() = binding.apply {
        rvRecipes.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
        rvRecipes.layoutManager = LinearLayoutManager(requireContext())
        rvRecipes.adapter = adapter
    }

    override fun setupViewModel() {
        binding.vm = vm
    }

    override fun setupObservers() {

    }
}

