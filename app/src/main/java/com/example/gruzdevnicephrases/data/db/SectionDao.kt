package com.example.gruzdevnicephrases.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gruzdevnicephrases.data.db.entities.Section

@Dao
interface SectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun new_section(item: Section)

    @Delete
    suspend fun del_section(item: Section)

    @Query("SELECT * FROM phrases_sections")
    fun get_all_sections(): LiveData<List<Section>>
}