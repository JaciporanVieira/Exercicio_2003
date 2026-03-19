package com.example.projeto18_03.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.projeto18_03.ui.components.PostCard
import com.example.projeto18_03.viewmodels.PostViewModel

@Composable
fun ListPostScreen(viewModel: PostViewModel = viewModel(), navController: NavHostController) {
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

        LazyColumn() {
            items(viewModel.posts){ post ->
                PostCard(post)
            }
        }
    }

}