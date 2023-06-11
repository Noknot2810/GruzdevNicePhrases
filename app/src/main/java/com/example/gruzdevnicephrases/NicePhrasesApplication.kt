package com.example.gruzdevnicephrases

import android.app.Application
import com.example.gruzdevnicephrases.data.db.NicePhrasesDB
import com.example.gruzdevnicephrases.data.repositories.PhrasesRepository
import com.example.gruzdevnicephrases.ui.main.MainViewModelFactory
import com.example.gruzdevnicephrases.ui.main.SListViewModelFactory
import com.example.gruzdevnicephrases.ui.main.SectionViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class NicePhrasesApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@NicePhrasesApplication))
        bind() from singleton { NicePhrasesDB(instance()) }
        bind() from singleton { PhrasesRepository(instance()) }
        bind() from singleton {
            SectionViewModelFactory(instance())
        }
        bind() from singleton {
            MainViewModelFactory(instance())
        }
        bind() from singleton {
            SListViewModelFactory(instance())
        }
    }
}