package com.example.gruzdevnicephrases.data.db.entities

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "users_phrases",
        foreignKeys = [ForeignKey(entity = Section::class,
                                  parentColumns = arrayOf("id"),
                                  childColumns = arrayOf("phrase_section_id"),
                                  onDelete = ForeignKey.CASCADE)])

data class Phrase(

    @ColumnInfo(name = "phrase_text")
    var text: String,
    @ColumnInfo(name = "phrase_section_id")
    @Nullable
    var section_id: Int?,
    @ColumnInfo(name = "phrase_grades_count")
    var gcount: Int,
    @ColumnInfo(name = "phrase_grades_rating")
    var grating: Float
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
