package com.faceless.techfugeessurvailanceapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faceless.techfugeessurvailanceapp.data.repository.AuthRepository
import com.faceless.techfugeessurvailanceapp.data.repository.BaseRepository
import com.faceless.techfugeessurvailanceapp.ui.auth.AuthViewModel

class ViewModelFactory  (
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalAccessException("ViewModelClass Not Found")
        }
    }
}