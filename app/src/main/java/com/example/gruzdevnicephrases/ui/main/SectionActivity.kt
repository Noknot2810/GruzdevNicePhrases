package com.example.gruzdevnicephrases.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.databinding.ActivityMainBinding
import com.example.gruzdevnicephrases.databinding.ActivitySectionBinding
import com.example.gruzdevnicephrases.others.PhraseAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SectionActivity: AppCompatActivity(), KodeinAware {
    private lateinit var binding: ActivitySectionBinding

    override val kodein by kodein()
    private val factory: SectionViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val database = NicePhrasesDB(this)
        //val repository = PhrasesRepository(database)
        //val factory = MainViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(SectionViewModel::class.java)

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
        }
    }
}