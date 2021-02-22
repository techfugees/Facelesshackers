package com.faceless.techfugeessurvailanceapp.data.repository

import com.faceless.techfugeessurvailanceapp.data.UserPreferences
import com.faceless.techfugeessurvailanceapp.data.network.AuthApi
import com.faceless.techfugeessurvailanceapp.data.network.UserApi

class UserRepository (
    private val api: UserApi
) : BaseRepository(){


    suspend fun getUser() =safeApiCall {
        api.getUser()
    }
}