package com.example.gruzdevnicephrases.ui.main

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.gruzdevnicephrases.R
import com.example.gruzdevnicephrases.data.db.Date
import com.example.gruzdevnicephrases.data.db.entities.Phrase
import com.example.gruzdevnicephrases.databinding.DialogAddPhraseBinding

class AddPhraseDialog (context: Context, var newDialogListener: NewPhraseDialogListener) : AppCompatDialog(context)
{
    private lateinit var binding: DialogAddPhraseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddPhraseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val text = binding.etName.text.toString()
            if(text.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a phrase", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Phrase(text, null, 0, 0.0f, null, null, null)
            newDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}