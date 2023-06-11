package com.example.gruzdevnicephrases.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gruzdevnicephrases.R
import com.example.gruzdevnicephrases.data.db.NicePhrasesDB
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository
import com.example.gruzdevnicephrases.databinding.ActivityMainBinding
import com.example.gruzdevnicephrases.others.PhraseAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = NicePhrasesDB(this)
        val repository = PhrasesRepository(database)
        val factory = MainViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        val adapter = PhraseAdapter(listOf(), viewModel)

        binding.rvPhrases.layoutManager = LinearLayoutManager(this)
        binding.rvPhrases.adapter = adapter

        viewModel.get_all_phrases().observe(this, Observer {
            adapter.phrases = it
            adapter.notifyDataSetChanged()
        })

        binding.ivAddPhrase.setOnClickListener {
            AddPhraseDialog(
                this,
                object : NewPhraseDialogListener {
                    override fun onAddButtonClicked(item: Phrase) {
                        viewModel.new_phrase(item)
                    }
                }).show()
            //fab.setOnClickListener {
            //    AddShoppingItemDialog(
            //        this,
            //        object : AddDialogListener {
            //            override fun onAddButtonClicked(item: ShoppingItem) {
            //                viewModel.upsert(item)
            //            }
            //        }).show()
            //}
        }
    }
}