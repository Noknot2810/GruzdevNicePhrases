package com.example.gruzdevnicephrases.ui.section

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository

@Suppress("UNCHECKED_CAST")
class SectionViewModelFactory (
    private val repository: PhrasesRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SectionViewModel(repository) as T
    }
}