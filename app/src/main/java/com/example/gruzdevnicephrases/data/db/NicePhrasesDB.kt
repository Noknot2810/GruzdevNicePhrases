package com.example.gruzdevnicephrases.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.data.db.entities.Section

@Database(
    entities = [Section::class, Phrase::class],
    version = 4
)
abstract class NicePhrasesDB : RoomDatabase() {
    abstract fun getSectionDao(): SectionDao
    abstract fun getPhrasesDao(): PhrasesDao

    companion object{
        @Volatile
        private var instance: NicePhrasesDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                NicePhrasesDB::class.java,"NPDB").fallbackToDestructiveMigration().build()
    }
}