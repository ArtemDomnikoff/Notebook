package com.example.notebook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SecondActivity : AppCompatActivity() {

    fun generateItems(url: String, type: String): List<ItemImage> {
        return (1..30000).map {
            ItemImage(
                id = it,
                title = "$type $it",
                imageUrl = url
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data: List<ItemImage>
        val intent = getIntent()
        val item = intent.getStringExtra("item")

        if (item == "book"){
            data = generateItems("https://upload.wikimedia.org/wikipedia/commons/c/c7/Americanstudbookvolume2open.jpg", "book")
        }
        else{
            data = generateItems("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Example.jpg/400px-Example.jpg", "film")
        }



        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter( data)
    }
}