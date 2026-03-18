package com.example.projeto18_03.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto18_03.data.models.Post
import com.example.projeto18_03.data.repositories.PostRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var posts  = mutableStateListOf<Post>()

    fun loadPosts(){
        viewModelScope.launch {
            try {
                posts.clear()
                posts.addAll(PostRepository().fetchPosts())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}