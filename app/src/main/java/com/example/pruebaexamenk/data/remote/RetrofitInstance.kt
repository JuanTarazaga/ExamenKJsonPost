package com.example.pruebaexamenk.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val JSONPLACEHOLDER_URL = "https://jsonplaceholder.typicode.com"

    val jsonplaceholder: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(JSONPLACEHOLDER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}