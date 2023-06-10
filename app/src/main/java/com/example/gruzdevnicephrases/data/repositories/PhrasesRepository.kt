package com.example.gruzdevnicephrases.data.repositories

import com.example.gruzdevnicephrases.data.db.NicePhrasesDB
import com.example.gruzdevnicephrases.data.db.entities.Phrase

class PhrasesRepository (
    private val db: NicePhrasesDB
) {
    suspend fun new_phrase(item: Phrase) = db.getPhrasesDao().new_phrase(item)

    suspend fun del_phrase(item: Phrase) = db.getPhrasesDao().del_phrase(item)

    fun get_all_phrases() = db.getPhrasesDao().get_all_phrases()
}