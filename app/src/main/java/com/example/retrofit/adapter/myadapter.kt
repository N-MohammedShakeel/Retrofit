package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.modal.Post

class myadapter: RecyclerView.Adapter<myadapter.MyViewHolder>(){

    private var postlist = emptyList<Post>()

    inner class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val userid = holder.itemView.findViewById<TextView>(R.id.userid)
        val id = holder.itemView.findViewById<TextView>(R.id.id)
        val title = holder.itemView.findViewById<TextView>(R.id.title)
        val body = holder.itemView.findViewById<TextView>(R.id.body)

        userid.text = postlist[position].userid.toString()
        id.text = postlist[position].id.toString()
        title.text = postlist[position].title
        body.text = postlist[position].body

    }
    fun setData(newList: Post){
        postlist = listOf(newList)
        notifyDataSetChanged()
    }
}