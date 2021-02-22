package com.faceless.techfugeessurvailanceapp.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faceless.techfugeessurvailanceapp.data.network.Resource
import com.faceless.techfugeessurvailanceapp.data.repository.UserRepository
import com.faceless.techfugeessurvailanceapp.data.response.LoginResponse
import kotlinx.coroutines.launch

class DashboardViewModel (
    private val repository: UserRepository
) : ViewModel() {

    private val _user: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val user: LiveData<Resource<LoginResponse>>
    get() = _user


    fun getUser() = viewModelScope.launch {
        _user.value = repository.getUser()
    }
}