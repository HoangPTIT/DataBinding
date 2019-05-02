package com.example.hdev.databindingsample.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.ViewModelProviders
import com.example.hdev.databindingsample.data.viewmodels.AnimalsViewModel

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
