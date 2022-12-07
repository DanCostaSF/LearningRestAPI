package com.ocanha.retrofitcomkotlin.view.newrecipes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ocanha.retrofitcomkotlin.R
import com.ocanha.retrofitcomkotlin.commons.BaseFragment
import com.ocanha.retrofitcomkotlin.commons.navBack
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.databinding.FragmentNewRecipesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewRecipesFragment : BaseFragment<FragmentNewRecipesBinding>(
    R.layout.fragment_new_recipes
) {

    private val viewModel: NewRecipesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun setupObservers() {
        viewModel.status.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(
                    requireContext(),
                    "Receita salva com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                navBack()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Erro ao salvar a receita. Tente novamente.",
                    Toast.LENGTH_SHORT
                ).show()
                this.binding.fabNewRecipe.visibility = View.GONE
//                this.binding.loadingView.dismiss()
            }
        }
    }

    private fun setupUi() {

        this.binding.apply {

            fabNewRecipe.setOnClickListener {

                if (edtRecipeTitle.text.isEmpty()) {
                    edtRecipeTitle.error = "Preencha o nome da receita"
                    edtRecipeTitle.requestFocus()
                    return@setOnClickListener
                }

                if (edtRecipeAuthor.text.isEmpty()) {
                    edtRecipeAuthor.error = "Preencha o autor da receita"
                    edtRecipeAuthor.requestFocus()
                    return@setOnClickListener
                }

                if (edtRecipeIngredients.text.isEmpty()) {
                    edtRecipeIngredients.error = "Preencha os ingredientes da receita"
                    edtRecipeIngredients.requestFocus()
                    return@setOnClickListener
                }

                if (!rbTypeSalt.isChecked && !rbTypeSweet.isChecked) {
                    Toast.makeText(
                        requireContext(),
                        "Selecione o tipo da receita",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                val type = if (rbTypeSweet.isChecked) {
                    "Doce"
                } else {
                    "Salgado"
                }

                val recipe = Recipe(
                    author = edtRecipeAuthor.text.toString(),
                    name = edtRecipeTitle.text.toString(),
                    type = type,
                    ingredients = edtRecipeIngredients.text.toString()
                )

                fabNewRecipe.visibility = View.GONE
                viewModel.saveRecipe(recipe)

            }
        }
    }
}