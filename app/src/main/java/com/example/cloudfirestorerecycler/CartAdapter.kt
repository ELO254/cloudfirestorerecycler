package com.example.cloudfirestorerecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CartAdapter(var data:List<Items>, var onclick:((Items) -> Unit)?): RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var imageView: ImageView = view.findViewById(R.id.imgcart)
        var amount: TextView = view.findViewById(R.id.txtamountcart)
        var itemname: TextView = view.findViewById(R.id.txtnamecart)
        var button: Button = view.findViewById(R.id.btnremove)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycart, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var place = data[position]

        holder.itemname.text = place.name
        holder.amount.text = place.amount.toString()
        Glide.with(holder.itemView)
            .load(place.image)
            .into(holder.imageView)

        onclick?.let { click ->
            holder.button.setOnClickListener { click(place) }
        }


    }
}