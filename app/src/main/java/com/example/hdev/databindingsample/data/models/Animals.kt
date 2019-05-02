package com.example.hdev.databindingsample.data.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.hdev.databindingsample.BR
import java.io.Serializable

/**
 * Binding two-way
 */
class Animals : BaseObservable(), Serializable {

    companion object {
        fun build(name: String, style: String): Animals {
            val animals = Animals()
            animals.nameAnimals = name
            animals.styleAnimals = style
            
            return animals
        }
    }

    @Bindable
    var nameAnimals = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.nameAnimals)
        }

    @Bindable
    var styleAnimals = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.styleAnimals)
        }
}
