package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.repository.repository

@Suppress("UNCHECKED_CAST")
class MainViewModalFactory (private val repository: repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModal(repository) as T
    }

}