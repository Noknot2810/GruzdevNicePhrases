package com.example.gruzdevnicephrases.ui.slist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.gruzdevnicephrases.data.db.entities.Section
import com.example.gruzdevnicephrases.databinding.DialogDelSectionBinding

class DelSectionDialog (context: Context, var delDialogListener: DelSectionDialogListener, var section: Section) : AppCompatDialog(context)
{
    private lateinit var binding: DialogDelSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogDelSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvYes.setOnClickListener {
            delDialogListener.onDelButtonClicked(section)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}