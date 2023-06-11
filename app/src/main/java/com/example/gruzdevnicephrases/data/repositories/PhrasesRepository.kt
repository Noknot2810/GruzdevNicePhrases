package com.example.gruzdevnicephrases.data.repositories

import com.example.gruzdevnicephrases.data.db.NicePhrasesDB
import com.example.gruzdevnicephrases.data.db.entities.Phrase

class PhrasesRepository (
    private val db: NicePhrasesDB
) {
    suspend fun new_phrase(item: Phrase) = db.getPhrasesDao().new_phrase(item)

    suspend fun del_phrase(item: Phrase) = db.getPhrasesDao().del_phrase(item)

    fun get_all_phrases() = db.getPhrasesDao().get_all_phrases()

    suspend fun get_random_phrase() = db.getPhrasesDao().get_random_phrase()

    fun get_day_phrase(d: Int, m: Int, y: Int) = db.getPhrasesDao().get_day_phrase(d, m, y)

    fun create_day_phrase(d: Int, m: Int, y: Int) =  db.getPhrasesDao().create_day_phrase(d, m, y)

    fun get_section_phrases(section_id: Int) = db.getPhrasesDao().get_section_phrases(section_id)

    fun set_phrase_tdate(id: Int) = db.getPhrasesDao().set_phrase_tdate(id)

}