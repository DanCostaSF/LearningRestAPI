package com.ocanha.retrofitcomkotlin.view.recipes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocanha.retrofitcomkotlin.R
import com.ocanha.retrofitcomkotlin.commons.BaseFragment
import com.ocanha.retrofitcomkotlin.commons.navTo
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.databinding.FragmentRecipesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesFragment : BaseFragment<FragmentRecipesBinding>(
    R.layout.fragment_recipes
) {

    private val vm: RecipesViewModel by viewModel()
    private val adapter = RecipesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        vm.getAllRecipes()
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
        vm.recipesList.observe(viewLifecycleOwner){ recipes ->
            adapter.setRecipesList(recipes)
        }

        vm.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }

        vm.navigateToNewRecipe.observe(viewLifecycleOwner) {
            if (it) {
                navTo(RecipesFragmentDirections.actionRecipesFragmentToFragmentNewRecipes())
                vm.navigateOff()
            }
        }
    }
}