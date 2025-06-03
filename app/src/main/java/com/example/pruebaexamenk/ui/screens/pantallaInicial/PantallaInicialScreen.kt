package com.example.pruebaexamenk.ui.screens.pantallaInicial

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.pruebaexamenk.data.model.Posts
import com.example.pruebaexamenk.ui.components.navigation.Destinations
import com.example.pruebaexamenk.ui.components.List
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.unit.dp

@Composable
fun PantallaInicialScreen(
    navController: NavController,
    PantallaInicialViewModel: PantallaInicialViewModel = hiltViewModel()
) {
    var isLoading by remember { mutableStateOf(true) }
    var showDialog by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var editingPost by remember { mutableStateOf<Posts?>(null) }

    LaunchedEffect(Unit) {
        PantallaInicialViewModel.getPosts()
        isLoading = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(PantallaInicialViewModel.posts) { post ->
                    List(
                        post = post,
                        onClick = {
                            navController.navigate("${Destinations.PANTALLA_SECUNDARIA}/${post.id}")
                        },
                        onDelete = {
                            PantallaInicialViewModel.deletePost(post.id)
                        },
                        onEdit = {
                            editingPost = post
                            title = post.title
                            body = post.body
                            showDialog = true
                        }
                    )
                }
            }

            FloatingActionButton(
                onClick = { showDialog = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Añadir nuevo post"
                )


                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            TextButton(onClick = {
                                if (editingPost != null) {
                                    PantallaInicialViewModel.updatePost(editingPost!!.id, title, body)
                                } else {
                                    PantallaInicialViewModel.createPost(title, body)
                                }
                                showDialog = false
                                editingPost = null
                                title = ""
                                body = ""
                            }) {
                                Text(if (editingPost != null) "Actualizar" else "Añadir")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("Cancelar")
                            }
                        },
                        title = { Text("Editar/Añadir Post") },
                        text = {
                            Column {
                                OutlinedTextField(
                                    value = title,
                                    onValueChange = { title = it },
                                    label = { Text("Título") },
                                    singleLine = true
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                OutlinedTextField(
                                    value = body,
                                    onValueChange = { body = it },
                                    label = { Text("Contenido") },
                                    maxLines = 10
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}