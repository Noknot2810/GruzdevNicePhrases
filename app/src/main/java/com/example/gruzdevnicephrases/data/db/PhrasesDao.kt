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
    fun get_all_phrases(): LiveData<List<Phrase>>

}