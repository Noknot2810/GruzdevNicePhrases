package com.example.gruzdevnicephrases.data.db.entities

import androidx.annotation.Nullable
import androidx.room.*
import com.example.gruzdevnicephrases.data.db.Date

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
    var grating: Float,
    @ColumnInfo(name = "phrase_tday")
    var tday: Int?,
    @ColumnInfo(name = "phrase_tmonth")
    var tmonth: Int?,
    @ColumnInfo(name = "phrase_tyear")
    var tyear: Int?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
