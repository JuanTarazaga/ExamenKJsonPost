package com.example.pruebaexamenk.data.repositories

import com.example.pruebaexamenk.data.model.Posts
import com.example.pruebaexamenk.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    suspend fun getPosts(): List<Posts>? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.jsonplaceholder.getPosts().execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun getPost(id: Int): Posts? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.jsonplaceholder.getPost(id).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun deletePost(id: Int): Posts? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.jsonplaceholder.deletePost(id).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun postPost(post: Posts): Posts? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.jsonplaceholder.postPost(post).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun putPost(id: Int, post: Posts): Posts? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.jsonplaceholder.putPost(id, post).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

}