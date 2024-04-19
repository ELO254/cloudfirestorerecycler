package com.example.cloudfirestorerecycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var recy:RecyclerView = findViewById(R.id.recyclerview)

        var adapter = CartAdapter(Cart.getList()){
            Cart.removeItem(it)
        }

        recy.adapter = adapter
        recy.layoutManager =LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
    }
}