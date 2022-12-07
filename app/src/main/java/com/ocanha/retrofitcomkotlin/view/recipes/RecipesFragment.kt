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
        setupFab()
        setupRecycler()
    }

    override fun onResume() {
        super.onResume()
    //        this.binding.loadingView.show()
        vm.getAllRecipes()
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
        vm.recipesList.observe(viewLifecycleOwner){ recipes ->
//            this.binding.loadingView.dismiss()
            updateRecipesList(recipes)
        }

        vm.errorMessage.observe(viewLifecycleOwner) {
//            this.binding.loadingView.dismiss()
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            updateRecipesList(listOf())
        }
    }

    private fun updateRecipesList(recipes: List<Recipe>) {

        adapter.setRecipesList(recipes)

        binding.apply {
            if (recipes.isEmpty()) {
                rvRecipes.visibility = View.GONE
                imgNoRecipes.visibility = View.VISIBLE
                tvNoRecipes.visibility = View.VISIBLE
            } else {
                rvRecipes.visibility = View.VISIBLE
                imgNoRecipes.visibility = View.GONE
                tvNoRecipes.visibility = View.GONE
            }
        }
    }
}