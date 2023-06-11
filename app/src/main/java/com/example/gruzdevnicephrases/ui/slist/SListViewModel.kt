package com.example.gruzdevnicephrases.ui.slist

import androidx.lifecycle.ViewModel
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.data.db.entities.Section
import com.example.gruzdevnicephrases.data.repositories.SectionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SListViewModel (
    private val repository: SectionRepository
) : ViewModel() {
    fun new_section(item: Section) = CoroutineScope(Dispatchers.Main).launch {
        repository.new_section(item)
    }

    fun del_section(item: Section) = CoroutineScope(Dispatchers.Main).launch {
        repository.del_section(item)
    }

    fun get_all_sec() = repository.get_all_sections()
}