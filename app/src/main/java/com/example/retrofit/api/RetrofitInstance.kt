package com.example.retrofit.api

import com.example.retrofit.adapter.MyIntercepter
import com.example.retrofit.utils.Constatnts.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var client = OkHttpClient.Builder().apply{
        addInterceptor(MyIntercepter())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}