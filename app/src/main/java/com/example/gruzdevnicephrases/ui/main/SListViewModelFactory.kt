package com.example.gruzdevnicephrases.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gruzdevnicephrases.data.repositories.SectionRepository

@Suppress("UNCHECKED_CAST")
class SListViewModelFactory (
    private val repository: SectionRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SListViewModel(repository) as T
    }
}