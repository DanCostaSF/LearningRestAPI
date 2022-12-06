package com.ocanha.retrofitcomkotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ocanha.retrofitcomkotlin.R
import com.ocanha.retrofitcomkotlin.di.RecipesDi
import org.koin.core.context.loadKoinModules


class MainActivity : AppCompatActivity() {

    private val module = RecipesDi.module

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            loadKoinModules(module)
    }
}