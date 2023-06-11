package com.example.gruzdevnicephrases.ui.main

import com.example.gruzdevnicephrases.data.db.entities.Phrase

interface NewPhraseDialogListener {
    fun onAddButtonClicked(item: Phrase)
}