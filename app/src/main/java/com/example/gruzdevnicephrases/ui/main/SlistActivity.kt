package com.example.gruzdevnicephrases.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gruzdevnicephrases.R
import com.example.gruzdevnicephrases.data.db.entities.Section
import com.example.gruzdevnicephrases.databinding.ActivitySlistBinding
import com.example.gruzdevnicephrases.others.SectionAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SlistActivity: AppCompatActivity(), KodeinAware {
    private lateinit var binding: ActivitySlistBinding

    override val kodein by kodein()
    private val factory: SListViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProviders.of(this, factory).get(SListViewModel::class.java)

        /*val adapter = SectionAdapter(listOf(), viewModel)

        binding.rvSections.layoutManager = LinearLayoutManager(this)
        binding.rvSections.adapter = adapter

        viewModel.get_all_sec().observe(this, Observer {
            adapter.sections = it
            adapter.notifyDataSetChanged()
        })

        binding.ivAddSection.setOnClickListener {
            AddSectionDialog(
                this,
                object : NewSectionDialogListener {
                    override fun onAddButtonClicked(item: Section) {
                        viewModel.new_section(item)
                    }
                }).show()
        }*/
    }
}