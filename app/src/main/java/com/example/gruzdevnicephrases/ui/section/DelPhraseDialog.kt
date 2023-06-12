package com.example.gruzdevnicephrases.ui.section

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.databinding.DialogDelPhraseBinding

class DelPhraseDialog (context: Context, var delDialogListener: DelPhraseDialogListener, var phrase: Phrase) : AppCompatDialog(context)
{
    private lateinit var binding: DialogDelPhraseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogDelPhraseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvYes.setOnClickListener {
            delDialogListener.onDelButtonClicked(phrase)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}