package com.example.gruzdevnicephrases.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.gruzdevnicephrases.R
import com.example.gruzdevnicephrases.data.db.NicePhrasesDB
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = NicePhrasesDB(this)
        val repository = PhrasesRepository(database)
        val factory = MainViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }
}