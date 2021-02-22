package com.faceless.techfugeessurvailanceapp.data.network

import com.faceless.techfugeessurvailanceapp.data.response.LoginResponse
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    suspend fun getUser(): LoginResponse
}