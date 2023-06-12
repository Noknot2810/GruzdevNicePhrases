package com.example.gruzdevnicephrases.ui.slist

import com.example.gruzdevnicephrases.data.db.entities.Section

interface DelSectionDialogListener {
    fun onDelButtonClicked(item: Section)
}