package com.example.pruebaexamenk.data.remote

import com.example.pruebaexamenk.data.model.Posts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("posts")
    fun getPosts(): Call<List<Posts>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Call<Posts>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<Posts>

    @POST("posts")
    fun postPost(@Body posts: Posts): Call<Posts>

    @PUT("posts/{id}")
    fun putPost(@Path("id") id: Int, @Body posts: Posts): Call<Posts>
}