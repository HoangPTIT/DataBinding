package com.example.hdev.databindingsample.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * @Custom setter
 */
class BindingUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("greetings")
        fun setName(view: TextView, text: String?) {
            view.text = "ABC: $text"
        }
    }
}
