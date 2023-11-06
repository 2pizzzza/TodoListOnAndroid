package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameFields: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)
        val listView = findViewById<ListView>(R.id.listContentToDo)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        button.setOnClickListener {
            val text = nameFields.text.toString().trim()
            if (nameFields.text.toString().isNotEmpty()){
                adapter.add(text)
            }
                Toast.makeText(this, "Fields connot be empty", Toast.LENGTH_SHORT).show()
        }

    }
}