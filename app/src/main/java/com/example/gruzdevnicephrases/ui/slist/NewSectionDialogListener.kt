package com.example.gruzdevnicephrases.ui.slist

import com.example.gruzdevnicephrases.data.db.entities.Section

interface NewSectionDialogListener {
    fun onAddButtonClicked(item: Section)
}