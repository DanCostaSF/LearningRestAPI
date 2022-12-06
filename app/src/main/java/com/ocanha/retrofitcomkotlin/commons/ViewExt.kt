package com.ocanha.retrofitcomkotlin.commons

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar

@BindingAdapter("isVisibility")
fun View.isVisibility(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("isVisibleOrGone")
fun View.isVisibleOrGone(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

fun View.showSnackBar(sla: String) {
    Snackbar.make(
        this,
        sla,
        Snackbar.LENGTH_SHORT
    ).show()
}