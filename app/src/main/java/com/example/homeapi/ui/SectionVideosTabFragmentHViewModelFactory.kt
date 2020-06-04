package com.example.homeapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tapmad.webservices.Services.APIRepository



    @Suppress("UNCHECKED_CAST")
    class SectionVideosTabFragmentHViewModelFactory(private val repository: APIRepository): ViewModelProvider.NewInstanceFactory()
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SectionVideosTabFragmentHViewModel(repository) as T
        }
    }
