package com.example.projeto18_03.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.projeto18_03.data.models.Post
import com.example.projeto18_03.ui.components.PostCard
import com.example.projeto18_03.ui.components.PostDetailsDialog
import com.example.projeto18_03.viewmodels.PostViewModel

@Composable

fun PostScreen(
    navController: NavHostController,
    viewModel: PostViewModel = viewModel(),
    snackBarHostState: SnackbarHostState
) {
    var postId by remember { mutableStateOf("") }

    var selectedPost by remember { mutableStateOf<Post?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Buscar por Id")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = postId,
            onValueChange = { postId = it},
            label = { Text("Digite o Id do Post")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
               val id =  postId.toIntOrNull()
                if(id!= null){
                    viewModel.searchPostById(id)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buscar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
        viewModel.selectedPost?.let { post ->
            PostCard(
                post, onDeleteClick = { viewModel.deletePost(it) },
                onClick = { selectedPost = it }
            )
        }?: Text("Nenhum Post encontrado")
    }
    selectedPost?.let {
            post ->
        PostDetailsDialog(
            post,
            onDismiss = { selectedPost = null }
        )
    }




}