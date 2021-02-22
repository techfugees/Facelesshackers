package com.faceless.techfugeessurvailanceapp.data.repository

import com.faceless.techfugeessurvailanceapp.data.UserPreferences
import com.faceless.techfugeessurvailanceapp.data.network.AuthApi

class AuthRepository (
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository(){


    suspend fun login (
        email: String,

        password: String
    ) = safeApiCall {
        api.login(email, password)
    }


    suspend fun savAuthToken(token: String) {
        preferences.saveAuthToken(token)
    }
}