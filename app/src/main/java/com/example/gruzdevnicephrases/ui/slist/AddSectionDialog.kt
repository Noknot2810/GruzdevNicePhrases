package com.example.gruzdevnicephrases.ui.slist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.gruzdevnicephrases.data.db.entities.Section
import com.example.gruzdevnicephrases.databinding.DialogAddSectionBinding

class AddSectionDialog (context: Context, var newDialogListener: NewSectionDialogListener) : AppCompatDialog(context)
{
    private lateinit var binding: DialogAddSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name of section", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Section(name)
            newDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}