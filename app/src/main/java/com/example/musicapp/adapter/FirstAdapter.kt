package com.example.musicapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.R
import com.example.musicapp.model.Music
import com.example.musicapp.ui.FirstFragment

class FirstAdapter(val playList: MutableList<Music>, FirstFragment: FirstFragment) : RecyclerView.Adapter<FirstAdapter.MyHolder>() {

    var onItemClick : ((Music) -> Unit)? = null

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.photo)
        var music: TextView = itemView.findViewById(R.id.music)
        var author: TextView = itemView.findViewById(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstAdapter.MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item =playList[position]
        holder.photo.setImageResource(item.photo)
        holder.music.text=item.name
        holder.author.text=item.author

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }


    override fun getItemCount(): Int {
        return playList.size
    }





}