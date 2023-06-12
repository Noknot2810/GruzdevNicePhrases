package com.example.gruzdevnicephrases.ui.section

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.databinding.ActivitySectionBinding
import com.example.gruzdevnicephrases.others.PhraseAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SectionActivity: AppCompatActivity(), KodeinAware {
    private lateinit var binding: ActivitySectionBinding

    override val kodein by kodein()
    private val factory: SectionViewModelFactory by instance()
    private var section_id: Int? = null
    private var section_name: String? = null

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

        section_id = intent.extras?.getInt("section_id")
        section_name = intent.extras?.getString("section_name")
        if (section_name != null){
            Toast.makeText(this, "${section_name!!} clicked!", Toast.LENGTH_SHORT / 2).show()
            binding.txtSectionName.text = section_name!!
        }

        if (section_id == null){
            viewModel.get_all_phrases().observe(this, Observer {
                adapter.phrases = it
                adapter.notifyDataSetChanged()
            })
        }
        else{
            viewModel.get_section_phrases(section_id!!).observe(this, Observer {
                adapter.phrases = it
                adapter.notifyDataSetChanged()
            })
        }

        binding.ivAddPhrase.setOnClickListener {
            AddPhraseDialog(
                this,
                object : NewPhraseDialogListener {
                    override fun onAddButtonClicked(item: Phrase) {
                        item.section_id = section_id
                        viewModel.new_phrase(item)
                    }
                }).show()
        }
    }
}