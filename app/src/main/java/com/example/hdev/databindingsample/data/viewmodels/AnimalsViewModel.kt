package com.example.hdev.databindingsample.data.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnimalsViewModel : ViewModel() {
    val input: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
