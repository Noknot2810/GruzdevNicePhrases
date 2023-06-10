package com.example.gruzdevnicephrases.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gruzdevnicephrases.R
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.databinding.PhraseItemBinding
import com.example.gruzdevnicephrases.ui.main.MainViewModel

class PhraseAdapter(
    var phrases: List<Phrase>,
    private val viewModel: MainViewModel
): RecyclerView.Adapter<PhraseAdapter.PhrasesViewHolder>() {
    class PhrasesViewHolder(val binding: PhraseItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhrasesViewHolder {
        val binding = PhraseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhrasesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhrasesViewHolder, position: Int) {
        with(holder.binding) {
            val curPhrase = phrases[position]

            txtPhraseText.text = curPhrase.text
            txtRatingInfo.text = curPhrase.grating.toString() +
                    " (" + curPhrase.gcount.toString() + ")"

            ivDelete.setOnClickListener {
                viewModel.del_phrase(curPhrase)
            }

            ratingPhrase.setOnClickListener(){
                curPhrase.grating = (curPhrase.grating * curPhrase.gcount.toFloat() + ratingPhrase.rating)
                curPhrase.gcount++
                curPhrase.grating /= curPhrase.gcount.toFloat()
                txtRatingInfo.text = curPhrase.grating.toString() +
                        " (" + curPhrase.gcount.toString() + ")"
                ratingPhrase.isEnabled = false
                viewModel.new_phrase(curPhrase)
            }

        }
    }

    override fun getItemCount(): Int {
        return phrases.count()
    }
}