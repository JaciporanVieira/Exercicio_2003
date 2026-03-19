package com.example.projeto18_03.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto18_03.data.models.Post
import com.example.projeto18_03.data.repositories.PostRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var posts  = mutableStateListOf<Post>()
        private set
    var selectedPost by mutableStateOf<Post?>(null)
        private set

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

    fun searchPostById(id:Int){
        viewModelScope.launch {
            try{
                selectedPost = PostRepository().fetchPostById(id)
            }catch (e: Exception){
                posts.clear()
                e.printStackTrace()
            }
        }
    }

}