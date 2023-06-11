package com.example.gruzdevnicephrases.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gruzdevnicephrases.data.db.entities.Phrase

@Dao
interface PhrasesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun new_phrase(item: Phrase)

    @Delete
    suspend fun del_phrase(item: Phrase)

    @Query("SELECT * FROM users_phrases")
    //@Query("SELECT * FROM users_phrases ORDER BY RANDOM() LIMIT 1")
    fun get_all_phrases(): LiveData<List<Phrase>>

    @Query("SELECT * FROM users_phrases ORDER BY RANDOM() LIMIT 1")
    suspend fun get_random_phrase(): List<Phrase>

    @Query("SELECT * FROM users_phrases WHERE phrase_tday = :d AND phrase_tmonth = :m AND phrase_tyear = :y")
    suspend fun get_day_phrase(d: Int, m: Int, y: Int): List<Phrase>

    @Query("UPDATE users_phrases SET phrase_tday = :d, phrase_tmonth = :m, phrase_tyear = :y WHERE id IN (SELECT id FROM users_phrases ORDER BY RANDOM() LIMIT 1)")
    //@Query("UPDATE users_phrases SET phrase_tday = :d, phrase_tmonth = :m, phrase_tyear = :y")
    suspend fun create_day_phrase(d: Int, m: Int, y: Int)

    @Query("SELECT * FROM users_phrases WHERE phrase_section_id = :sect")
    fun get_section_phrases(sect: Int): LiveData<List<Phrase>>

    @Query("UPDATE users_phrases SET phrase_tday = 1, phrase_tmonth = 1, phrase_tyear = 2000 WHERE id = :id")
    fun set_phrase_tdate(id: Int)

}