package com.example.pruebaexamenk.ui.screens.pantallaSecundaria

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pruebaexamenk.ui.components.Description

@Composable
fun PantallaSecundariaScreen(
    id: Int,
    PantallaSecundariaViewModel: PantallaSecundariaViewModel = hiltViewModel()
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        PantallaSecundariaViewModel.getPost(id)
        isLoading = false
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        PantallaSecundariaViewModel.posts?.let { post ->
            Description(post)
        }
    }
}