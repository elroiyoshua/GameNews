package com.example.gamenews

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListGameAdapter(private val listGame: ArrayList<Game>) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_game,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listGame.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name,dev,price,photo,) = listGame[position]
        holder.imgPhoto.setImageResource(photo)
        holder.gameName.text =name
        holder.gameDev.text = dev
        holder.gamePrice.text = price

        holder.itemView.setOnClickListener{
            val intentDetail  = Intent(holder.itemView.context,DetailActivity::class.java)
            intentDetail.putExtra("key_game",listGame[position])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val gameName : TextView = itemView.findViewById(R.id.game_name)
        val gameDev : TextView = itemView.findViewById(R.id.game_dev)
        val gamePrice : TextView = itemView.findViewById(R.id.game_price)
    }

}