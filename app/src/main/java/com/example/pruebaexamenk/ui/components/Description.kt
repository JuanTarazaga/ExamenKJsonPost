package com.example.pruebaexamenk.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pruebaexamenk.data.model.Posts

@Composable
fun Description(post: Posts) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleLarge
            )

            Box(modifier = Modifier.padding(16.dp))

            Text(text = "Usuario: ${post.userId}", style = MaterialTheme.typography.bodyLarge)
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Contenido: ",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                modifier = Modifier.padding(16.dp),
                text = post.body, style = MaterialTheme.typography.bodyMedium
            )

            Box(modifier = Modifier.padding(16.dp))

            Text(text = "Número del post: ${post.id}", style = MaterialTheme.typography.bodyMedium)


        }
    }
}