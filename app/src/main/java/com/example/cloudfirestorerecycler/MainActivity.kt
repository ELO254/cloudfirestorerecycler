package com.example.cloudfirestorerecycler

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class MainActivity : AppCompatActivity() {

    lateinit var recy:RecyclerView
    lateinit var imagecart:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recy = findViewById(R.id.recycler)
        imagecart = findViewById(R.id.imgcart)

        var adapter = recycleAdapter(emptyList(), onclick = null)


        recy.adapter = adapter
        recy.layoutManager = GridLayoutManager(this,2)

        var Get = FirebaseFirestore.getInstance()

        Get.collection("product").get().addOnSuccessListener {
            var items = mutableListOf<Items>()
            for(document in it){
                var item = document.toObject(Items::class.java)
                items.add(item)
            }
            adapter = recycleAdapter(items) {
                Cart.addItem(it)
            }
            Toast.makeText(this, "data obtained", Toast.LENGTH_SHORT).show()

            adapter.notifyDataSetChanged()
            recy.adapter = adapter
            recy.layoutManager = GridLayoutManager(this,2)

        }.addOnFailureListener{
            Toast.makeText(this, "failure to upload", Toast.LENGTH_SHORT).show()
        }


        imagecart.setOnClickListener {
            var intent = Intent(this,CartActivity::class.java)
            startActivity(intent)
        }


    }
}