package com.example.homeapi

import android.app.Application
import com.example.homeapi.ui.SectionVideosTabFragmentHViewModelFactory
import com.tapmad.webservices.Services.APIRepository
import com.tapmad.webservices.Services.ApiService
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class HomeApiApplication: Application(), KodeinAware {

    override val kodein= Kodein.lazy {
        import(androidXModule(this@HomeApiApplication))
        bind() from singleton { ApiService() }
        bind() from singleton { APIRepository(instance()) }

        bind() from provider { SectionVideosTabFragmentHViewModelFactory(instance()) }


    }
}