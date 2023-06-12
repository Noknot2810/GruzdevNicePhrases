package com.example.gruzdevnicephrases.others

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.databinding.PhraseItemBinding
import com.example.gruzdevnicephrases.ui.section.DelPhraseDialog
import com.example.gruzdevnicephrases.ui.section.DelPhraseDialogListener
import com.example.gruzdevnicephrases.ui.section.SectionViewModel

class PhraseAdapter(
    var phrases: List<Phrase>,
    private val viewModel: SectionViewModel
): RecyclerView.Adapter<PhraseAdapter.PhrasesViewHolder>() {
    class PhrasesViewHolder(val binding: PhraseItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhrasesViewHolder {
        val binding = PhraseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhrasesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhrasesViewHolder, position: Int) {
        with(holder.binding) {
            val curPhrase = phrases[position]

            txtPhraseText.text = "«" + curPhrase.text + "»"// + curPhrase.tday.toString() + curPhrase.tmonth.toString() + curPhrase.tyear.toString()
            txtRatingInfo.text = "%.2f".format(curPhrase.grating) +
                    " (" + curPhrase.gcount.toString() + ")"

            ivDelete.setOnClickListener {
                DelPhraseDialog(
                    holder.itemView.context,
                    object : DelPhraseDialogListener {
                        override fun onDelButtonClicked(item: Phrase) {
                            viewModel.del_phrase(item)
                        }
                    },
                    curPhrase).show()

                //viewModel.del_phrase(curPhrase)
            }

            ratingPhrase.onRatingBarChangeListener =
                RatingBar.OnRatingBarChangeListener { ratingBar, _, _ ->
                    curPhrase.grating = (curPhrase.grating * curPhrase.gcount.toFloat() + ratingPhrase.rating)
                    curPhrase.gcount++
                    curPhrase.grating /= curPhrase.gcount.toFloat()
                    txtRatingInfo.text = "%.2f".format(curPhrase.grating) +
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