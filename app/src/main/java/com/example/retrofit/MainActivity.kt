package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapter.myadapter
import com.example.retrofit.repository.repository


class MainActivity : AppCompatActivity() {

    private lateinit var viewModal: MainViewModal

    private lateinit var myadapter : myadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

        val repository = repository()
        val viewModalFactory = MainViewModalFactory(repository)
        viewModal = ViewModelProvider(this, viewModalFactory).get(MainViewModal::class.java)

       // val mypost = Post (2,2,"shakeel","android developer")
       // viewModal.pushpost2(2,2,"shakeel","android developer")

        viewModal.getPost("1223456789")

//        viewModal.custompost(1, "id", "desc")
        viewModal.myResponse.observe(this, Observer {response ->

            Log.d("main",response.toString())
             response.let { myadapter.setData(it) }

        })


//        val bt  = findViewById<Button>(R.id.button)
//        val et = findViewById<EditText>(R.id.editTextNumber)
//
//        val options : HashMap<String,String> = HashMap()
//        options["_sort"] = "id"
//        options["_order"] = "desc"
//
//        bt.setOnClickListener{
//            val number = et.text.toString()
//            viewModal.custompost2(Integer.parseInt(number) , options )
//            val text = findViewById<TextView>(R.id.text)
//
//            viewModal.myResponse4.observe(this, Observer { response->
//
//                if (response.isSuccessful) {
//                    text.text = response.body().toString()
//                    et.text = null
//                }
//                else{
//                    text.text = response.errorBody().toString()
//                }
//
//
//            })
//
//        }


    }

    private fun setupRecyclerview(){
        val rv = findViewById<RecyclerView>(R.id.rv)
        myadapter = myadapter()
        rv.adapter = myadapter
        rv.layoutManager = LinearLayoutManager(this)


    }

}