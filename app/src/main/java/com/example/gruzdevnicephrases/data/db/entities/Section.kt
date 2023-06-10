package com.example.gruzdevnicephrases.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phrases_sections")
data class Section(
    @ColumnInfo(name = "section_name")
    var name: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
