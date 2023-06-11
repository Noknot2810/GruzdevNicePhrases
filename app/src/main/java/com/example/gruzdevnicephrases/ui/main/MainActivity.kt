package com.example.gruzdevnicephrases.ui.main

import android.content.Intent
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
import kotlinx.coroutines.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    private lateinit var binding: ActivityMainBinding

    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()
    private val db: NicePhrasesDB by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        binding.ivAddPhrase.setOnClickListener {
            val intent = Intent(this@MainActivity, SectionActivity::class.java).apply {  }
            startActivity(intent)
        }

        //binding.ivDayPhrase.setOnClickListener {  withContext(Dispatchers.Main) {
        //    binding.txtDayPhrase.text = viewModel.get_random_phrase()[0].text
            //val obj: Phrase
            //repository.get_random_phrase().invokeOnCompletion {
            //    obj = response.message
            //}
            //return@withContext repository.get_random_phrase()
            // do your network request logic here and return the result
        //}}

        binding.ivDayPhrase.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val derList = async {viewModel.get_random_phrase()}
                val phr = derList.await()
                binding.txtDayPhrase.text = phr[0].text
            }

            //val database = db.getInstance(context).YourClassDao()  // context could be an activity, for example.


            val getDataJob = GlobalScope.async { viewModel.get_random_phrase() }


            /*getDataJob.invokeOnCompletion { cause ->
                if (cause != null) {
                    Unit
                } else {
                    val myData = getDataJob.getCompleted()
                    //binding.txtDayPhrase.text = myData[0].text

                            // ITEM 1
                    // ***************************
                    // do something with your data
                    // ***************************

                    Unit  // this is just because the lambda here has to return Unit
                }
            }*/




        //set_random_phrase()
            //binding.txtDayPhrase.text = viewModel.get_random_phrase()

            //viewModel.get_random_phrase().observe(this, Observer {
            //    binding.txtDayPhrase.text = it[0].text
            //})
            /*viewModel.get_random_phrase().observe(this, Observer {
                val curPhrase = it[0]
                binding.txtDayPhrase.text = curPhrase.text
                curPhrase.tday = 1
                curPhrase.tmonth = 1
                curPhrase.tyear = 2000
                viewModel.new_phrase(curPhrase)
            })*/

            //@Suppress("UNCHECKED_CAST")
            //val curPhrase = viewModel.get_random_phrase()
            //curPhrase?.firstOrNull()?.run {
            //    binding.txtDayPhrase.text = this.text
            //}


            /*val phDao = db.getPhrasesDao()  // context could be an activity, for example.

            // start an async job to get the data
            val getDataJob = GlobalScope.async { phDao.get_random_phrase() }

            // tell the job to invoke this code when it's done
            getDataJob.invokeOnCompletion { cause ->
                if (cause != null) {
                    // error!  Handle that here
                    Unit
                } else {
                    val myData = getDataJob.getCompleted()
                    binding.txtDayPhrase.text = myData[0].text

                    // ITEM 1
                    // ***************************
                    // do something with your data
                    // ***************************

                    Unit  // this is just because the lambda here has to return Unit
                }
            }*/



            //binding.txtDayPhrase.text = viewModel.get_random_phrase().text


            //binding.txtDayPhrase.text = curPhrase.text
        }

        //viewModel.get_random_phrase().observe(this, Observer {
        //    //binding.txtDayPhrase.text = it[0].text
        //})

        //viewModel.get_random_phrase().observe(this, Observer {
        //    binding.txtDayPhrase.text = it[0].text
        //})



        //val database = NicePhrasesDB(this)
        //val repository = PhrasesRepository(database)
        //val factory = MainViewModelFactory(repository)

        /*val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

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
        }*/



    }


}