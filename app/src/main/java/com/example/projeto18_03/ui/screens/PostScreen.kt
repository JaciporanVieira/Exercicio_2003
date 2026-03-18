package com.example.projeto18_03.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projeto18_03.ui.components.PostCard
import com.example.projeto18_03.viewmodels.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel = viewModel() ) {
    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }
    Text("POSTS")
    Spacer(modifier = Modifier.padding(16.dp))
    LazyColumn() {
        items(viewModel.posts){ post ->
            PostCard(post)
        }
    }
}