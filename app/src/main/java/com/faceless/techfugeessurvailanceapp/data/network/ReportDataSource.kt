package com.faceless.techfugeessurvailanceapp.data.network

import com.faceless.techfugeessurvailanceapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReportDataSource {

    companion object {
        private const val BASE_URL = "https://mtaa.shop/app-hook.php"
    }

    fun<Api> buildApi (
        api:Class<Api>
//        authToken: String? = null
    ) :Api{
        return Retrofit.Builder()
            .baseUrl(ReportDataSource.BASE_URL)
            .client(
                OkHttpClient.Builder()

//                    .addInterceptor {
//                        chain -> chain.proceed(chain.request().newBuilder().also {
//                        it.addHeader("Authorization", "Bearer $authToken")
//                    }.build())
//                    }
                    .also { client->
                        if (BuildConfig.DEBUG) {
                            val logging = HttpLoggingInterceptor();
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                            client.addInterceptor(logging)
                        }
                    }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}