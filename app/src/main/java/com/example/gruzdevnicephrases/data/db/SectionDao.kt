package com.example.gruzdevnicephrases.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.gruzdevnicephrases.data.db.entities.Section

@Dao
interface SectionDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun new_section(item: Section)

    @Delete
    suspend fun del_section(item: Section)
}