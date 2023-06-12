package com.example.gruzdevnicephrases.ui.section

import com.example.gruzdevnicephrases.data.db.entities.Phrase

interface DelPhraseDialogListener {
    fun onDelButtonClicked(item: Phrase)
}