package com.example.projeto18_03.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun ListPostScreen(
    viewModel: PostViewModel = viewModel(),
    navController: NavHostController,
    snackBarHostState: SnackbarHostState
) {
    var selectedPost by remember { mutableStateOf<Post?>(null) }

    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista de Posts")
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {navController.navigate("post_by_id")},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Buscar por ID")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {navController.navigate("create_post")},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Criar novo Post")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else{
            LazyColumn() {
                items(viewModel.posts){ post ->
                    PostCard(
                        post = post,
                        onDeleteClick = { id ->
                            viewModel.deletePost(id)
                        },
                        onClick = { clickedPost ->
                            selectedPost = clickedPost
                        }
                    )
                }
            }
        }
    }
    selectedPost?.let {
        post ->
        PostDetailsDialog(
            post,
            onDismiss = { selectedPost = null }
        )
    }








}