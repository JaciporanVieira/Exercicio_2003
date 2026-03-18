package com.example.projeto18_03.data.remote

import com.example.projeto18_03.data.models.Post
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>


}