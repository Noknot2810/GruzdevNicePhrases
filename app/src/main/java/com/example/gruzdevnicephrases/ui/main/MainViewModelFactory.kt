package com.example.gruzdevnicephrases.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory (
    private val repository: PhrasesRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}