package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.modal.Post
import com.example.retrofit.repository.repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModal(private val repository: repository) : ViewModel() {

    val myResponse: MutableLiveData<Post> = MutableLiveData()
    val myResponsep: MutableLiveData<Post> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse4: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushpost2(userid: Int,id:Int,title:String,body:String) {
        viewModelScope.launch {
            val response = repository.pushpost2(userid, id, title, body)
            myResponsep.value = response.body()

        }
    }
    fun pushpost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushpost(post)
            myResponsep.value = response.body()

        }
    }
    fun getPost0(auth: String) {
        viewModelScope.launch {
            val response = repository.getPost0(auth)
            myResponse.value = response

        }
    }

    fun getPost(s: String) {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }
    fun custompost(userid: Int , sort : String ,order : String ){
        viewModelScope.launch {
            val response = repository.custompost(userid , sort, order)
            myResponse3.value = response
        }
    }

    fun custompost2(userid: Int , options : Map<String,String> ){
        viewModelScope.launch {
            val response = repository.custompost2(userid , options)
            myResponse4.value = response
        }
    }
}