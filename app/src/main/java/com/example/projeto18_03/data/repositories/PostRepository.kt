package com.example.projeto18_03.data.repositories

import com.example.projeto18_03.data.models.Post
import com.example.projeto18_03.data.remote.RetrofitInstance

class PostRepository {
    suspend fun fetchPosts():List<Post> {
        return RetrofitInstance.api.getPosts();
    }
}