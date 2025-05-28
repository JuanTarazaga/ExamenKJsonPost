package com.example.pruebaexamenk.ui.screens.pantallaSecundaria

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pruebaexamenk.data.model.Posts
import com.example.pruebaexamenk.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PantallaSecundariaViewModel @Inject constructor(
    private val provideRepository: Repository
) : ViewModel() {
    var posts by mutableStateOf<Posts?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    suspend fun getPost(id: Int) {
        val result = provideRepository.getPost(id = id)
        if (result != null) {
            this.posts = result
            this.errorMessage = null
        } else {
            this.errorMessage = "Post no encontrado"
        }
    }
}
