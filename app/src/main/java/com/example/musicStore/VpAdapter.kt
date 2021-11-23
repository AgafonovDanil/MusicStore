package com.example.musicStore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VpAdapter(val context: Context,val list: ArrayList<start>) : RecyclerView.Adapter<VpAdapter.MyVh>() {
    class MyVh(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textName)
        val hello: TextView = itemView.findViewById(R.id.textHello)
        val image: ImageView = itemView.findViewById(R.id.imagevewlogoStart)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVh {
       val root = LayoutInflater.from(context).inflate(R.layout.vp_adapter,parent,false )

        return MyVh(root)
    }

    override fun onBindViewHolder(holder: MyVh, position: Int) {
    holder.name.text = list[position].name
        holder.hello.text = list[position].hello
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}