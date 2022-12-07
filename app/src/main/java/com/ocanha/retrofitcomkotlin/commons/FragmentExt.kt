package com.ocanha.retrofitcomkotlin.commons

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navTo(directions: NavDirections) = findNavController().navigate(directions)
fun Fragment.navBack() = findNavController().navigateUp()