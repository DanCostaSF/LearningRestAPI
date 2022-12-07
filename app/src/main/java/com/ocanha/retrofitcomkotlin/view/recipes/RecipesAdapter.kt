package com.ocanha.retrofitcomkotlin.view.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ocanha.retrofitcomkotlin.data.model.Recipe
import com.ocanha.retrofitcomkotlin.databinding.ResItemRecipesBinding

class RecipesAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var recipes = mutableListOf<Recipe>()

    fun setRecipesList(lives: List<Recipe>) {
        this.recipes = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemRecipesBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val live = recipes[position]
        holder.bind(live)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class MainViewHolder(private val binding: ResItemRecipesBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: Recipe) {
        binding.tvRecipeTitle.text = recipe.name
        binding.tvRecipeAuthor.text = "Autor: ${recipe.author}"
        binding.tvRecipeType.text = "Tipo: ${recipe.type}"

    }
}