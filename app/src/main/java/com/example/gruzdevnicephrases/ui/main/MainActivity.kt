package com.example.gruzdevnicephrases.ui.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
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
import java.util.*

class MainActivity : AppCompatActivity(), KodeinAware {

    private lateinit var binding: ActivityMainBinding

    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()
    private val db: NicePhrasesDB by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDayPhrase.isInvisible = true

        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        binding.ivAddPhrase.setOnClickListener {
            //val intent = Intent(this@MainActivity, SectionActivity::class.java).apply {  }

            val intent = Intent(this@MainActivity, SlistActivity::class.java).apply {  }
            startActivity(intent)
            binding.txtAnnounce.text = "Tap below to know the day phrase"
            binding.ivDayPhrase.isEnabled = true
            binding.ivDayPhrase.isInvisible = false
            binding.txtDayPhrase.isInvisible = true
        }

        binding.ivDayPhrase.setOnClickListener {
            binding.txtAnnounce.text = "Phrase of the day:"
            binding.ivDayPhrase.isEnabled = false
            binding.ivDayPhrase.isInvisible = true
            binding.txtDayPhrase.isInvisible = false
            CoroutineScope(Dispatchers.Main).launch {
                val calendar = Calendar.getInstance()

                var derPhrList = async {viewModel.get_day_phrase(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR))}
                var PhrList = derPhrList.await()
                if (PhrList.size < 1){
                    derPhrList = async {
                        viewModel.create_day_phrase(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR))
                        viewModel.get_day_phrase(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR))
                    }
                    PhrList = derPhrList.await()
                    if (PhrList.size < 1){
                        binding.txtDayPhrase.text = "You haven't added a single phrase yet"
                        binding.txtDayPhrase.setTextColor(Color.parseColor("#0aad3f"))
                    }
                    else{
                        binding.txtDayPhrase.setTextColor(Color.parseColor("#000000"))
                        binding.txtDayPhrase.text = "«" + PhrList[0].text + "»"
                    }
                }
                else{
                    binding.txtDayPhrase.setTextColor(Color.parseColor("#000000"))
                    binding.txtDayPhrase.text = "«" + PhrList[0].text + "»"
                }
            }
        }
    }


}