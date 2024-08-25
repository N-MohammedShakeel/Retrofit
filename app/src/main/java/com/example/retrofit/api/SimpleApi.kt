package com.example.retrofit.api

import com.example.retrofit.modal.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {
    //dynamic
    @GET("posts/1")
    suspend fun getPost0(@Header("Auth") auth: String): Post


    //static
    @Headers("Authorization: 123456789" , "Platform: android") // added header to specific request
    @GET("posts/1")
    suspend fun getPost(): Post  // if we change end point which does not exist we can use Response
                                 // Response is a part of retrofit library
                                 // Response<Post> in every place

    @GET("posts/{postNumber}")
    suspend fun getPost2(@Path("postNumber") number: Int): Response<Post>

    @GET("posts")
    suspend fun custompost(
        @Query("userid") number: Int,
        @Query("_sort") sort : String,
        @Query("_order") order : String
        ): Response<List<Post>>

    @GET("posts")
    suspend fun custompost2(
        @Query("userid") number: Int,
        @QueryMap options: Map<String,String>
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushpost(
        @Body post: Post
    ):Response<Post>

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushpost2(
        @Field("userid") userid: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String

    ):Response<Post>

}