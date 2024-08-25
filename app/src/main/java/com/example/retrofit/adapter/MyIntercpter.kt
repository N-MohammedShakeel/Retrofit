package com.example.retrofit.adapter

import okhttp3.Interceptor
import okhttp3.Response

class MyIntercepter : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =  chain.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("Content-Type","android")
            .addHeader("Content-Type","123456789")
            .build()
        return chain.proceed(request)

    }
}