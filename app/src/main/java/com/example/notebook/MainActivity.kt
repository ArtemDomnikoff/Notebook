package com.example.notebook

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonFilms: Button = findViewById(R.id.button_films)
        val buttonBooks: Button = findViewById(R.id.button_books)

        val intent = Intent(this, SecondActivity::class.java)

        buttonBooks.setOnClickListener {
            val items = listOf("1984", "Война и мир", "451 Градус по Фаренгейту")
            intent.putStringArrayListExtra("items", ArrayList(items))
            startActivity(intent)
        }
        buttonFilms.setOnClickListener {
            val items = listOf("Титаник", "1+1", "Зелёная миля")
            intent.putStringArrayListExtra("items", ArrayList(items))
            startActivity(intent)
        }

    }
}