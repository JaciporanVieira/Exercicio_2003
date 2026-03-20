package com.example.projeto18_03.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto18_03.data.models.Post
import com.example.projeto18_03.data.remote.post.RetrofitInstance
import com.example.projeto18_03.data.repositories.PostRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private var allPosts = listOf<Post>()

    var posts  = mutableStateListOf<Post>()
        private set
    var selectedPost by mutableStateOf<Post?>(null)
        private set
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun loadPosts(){
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = PostRepository().fetchPosts()
                allPosts = response
                posts.clear()
                posts.addAll(response)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                isLoading = false
            }
        }
    }
    fun filterPostsByTitle(query: String){
        val filtered =
            if(query.isBlank()){
                allPosts
            }else{
                allPosts.filter { it.title.contains(query, ignoreCase = true) }
            }
        posts.clear()
        posts.addAll(filtered)
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
    suspend fun createPost(title:String, body:String): Boolean{
        isLoading = true
        errorMessage = null

        return try{
            val newPost = Post(
                userId = 1,
                title = title,
                body = body,
                id = 0
            )
            PostRepository().fetchAddPost(newPost)
            loadPosts()
            true
        }catch (e: Exception){
            errorMessage = "Erro ao criar o post"
            e.printStackTrace()
            false
        }finally {
            isLoading = false
        }
    }

    fun deletePost(id:Int){
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try{
                PostRepository().fetchDeletePost(id)
                loadPosts()
            }catch (e: Exception){
                errorMessage = "Erro ao deletar o post"
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    fun clearError(){
        errorMessage = null
    }

}