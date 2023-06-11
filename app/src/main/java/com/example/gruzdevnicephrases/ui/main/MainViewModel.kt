package com.example.gruzdevnicephrases.ui.main

import androidx.lifecycle.ViewModel
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainViewModel (
    private val repository: PhrasesRepository
) : ViewModel() {
    fun new_phrase(item: Phrase) = CoroutineScope(Dispatchers.Main).launch {
        repository.new_phrase(item)
    }

    fun del_phrase(item: Phrase) = CoroutineScope(Dispatchers.Main).launch {
        repository.del_phrase(item)
    }

    fun get_all_phrases() = repository.get_all_phrases()

    suspend fun get_random_phrase() = repository.get_random_phrase()

    //fun get_random_phrase() = CoroutineScope(Dispatchers.Main).launch {
    //    repository.get_random_phrase()
    //}

    //suspend fun get_random_phrase(): List<Phrase> = withContext(Dispatchers.Main) {
        //val obj: Phrase
        //repository.get_random_phrase().invokeOnCompletion {
        //    obj = response.message
        //}
    //    return@withContext repository.get_random_phrase()
        // do your network request logic here and return the result
    //}

    fun set_phrase_tdate(id: Int) = CoroutineScope(Dispatchers.Main).launch {
        repository.set_phrase_tdate(id)
    }

    //val calendar = Calendar.getInstance()
    //fun create_day_phrase() = repository.create_day_phrase(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR))
    fun create_day_phrase() = repository.create_day_phrase(1, 1, 2001)
}