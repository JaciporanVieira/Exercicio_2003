package com.example.projeto18_03.data.remote.post

import com.example.projeto18_03.data.models.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id:Int): Post

    @POST("posts")
    suspend fun addPost(@Body post: Post): Post



}