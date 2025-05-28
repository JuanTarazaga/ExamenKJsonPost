package com.example.pruebaexamenk.ui.screens.pantallaInicial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaexamenk.data.model.Posts
import com.example.pruebaexamenk.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PantallaInicialViewModel @Inject constructor (
    private val provideRepository: Repository
) : ViewModel() {
    var posts by mutableStateOf(listOf<Posts>())
        private set

    suspend fun getPosts(): List<Posts> {
        var result = provideRepository.getPosts()
        if (result != null) {
            this.posts = result
        }
        return this.posts
    }

    fun deletePost(id: Int) {
        viewModelScope.launch {
            val deletedProduct = provideRepository.deletePost(id)
            if (deletedProduct != null) {
                posts = posts.filter { it.id != id }
            }
        }
    }

    fun createPost(title: String, body: String) {
        viewModelScope.launch {
            val newPost = Posts(userId = 1, id = 0, title = title, body = body)
            val result = provideRepository.postPost(newPost)
            if (result != null) {
                posts = posts + result
            }
        }
    }

}