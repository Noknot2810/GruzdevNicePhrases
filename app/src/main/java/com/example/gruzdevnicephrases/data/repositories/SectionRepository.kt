package com.example.gruzdevnicephrases.data.repositories

import com.example.gruzdevnicephrases.data.db.NicePhrasesDB
import com.example.gruzdevnicephrases.data.db.entities.Section

class SectionRepository (
    private val db: NicePhrasesDB
) {
    suspend fun new_section(item: Section) = db.getSectionDao().new_section(item)

    suspend fun del_section(item: Section) = db.getSectionDao().del_section(item)

    fun get_all_sections() = db.getSectionDao().get_all_sections()
}