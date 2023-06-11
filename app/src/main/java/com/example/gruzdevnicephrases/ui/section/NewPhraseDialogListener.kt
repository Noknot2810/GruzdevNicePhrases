package com.example.gruzdevnicephrases.ui.section

import com.example.gruzdevnicephrases.data.db.entities.Phrase

interface NewPhraseDialogListener {
    fun onAddButtonClicked(item: Phrase)
}