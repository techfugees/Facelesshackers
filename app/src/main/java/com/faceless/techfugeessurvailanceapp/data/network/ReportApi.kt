package com.faceless.techfugeessurvailanceapp.data.network

import com.faceless.techfugeessurvailanceapp.data.response.LoginResponse
import com.faceless.techfugeessurvailanceapp.data.response.ReportResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ReportApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ) : ReportResponse
}