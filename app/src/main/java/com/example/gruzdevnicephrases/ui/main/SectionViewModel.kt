package com.example.gruzdevnicephrases.ui.main

import androidx.lifecycle.ViewModel
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SectionViewModel (
    private val repository: PhrasesRepository
) : ViewModel() {
    fun new_phrase(item: Phrase) = CoroutineScope(Dispatchers.Main).launch {
        repository.new_phrase(item)
    }

    fun del_phrase(item: Phrase) = CoroutineScope(Dispatchers.Main).launch {
        repository.del_phrase(item)
    }

    fun get_all_phrases() = repository.get_all_phrases()
}