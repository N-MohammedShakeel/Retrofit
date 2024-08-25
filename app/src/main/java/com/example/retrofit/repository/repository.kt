package com.example.retrofit.repository

import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.modal.Post
import retrofit2.Response

class repository {
    suspend fun getPost0(auth: String) : Post
    {
        return RetrofitInstance.api.getPost0(auth)
    }
    suspend fun getPost() : Post
    {
        return RetrofitInstance.api.getPost()
    }
    suspend fun getPost2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun custompost(userid : Int , sort : String ,order : String):Response<List<Post>>{
        return RetrofitInstance.api.custompost(userid , sort , order)
    }
    suspend fun custompost2(userid : Int , options : Map<String,String>):Response<List<Post>>{
        return RetrofitInstance.api.custompost2(userid , options)
    }
    suspend fun pushpost(post: Post) : Response<Post>

    {
        return RetrofitInstance.api.pushpost(post)
    }
    suspend fun pushpost2(userid :Int , id:Int , title:String , body:String) : Response<Post>

    {
        return RetrofitInstance.api.pushpost2(userid, id, title, body)
    }

}