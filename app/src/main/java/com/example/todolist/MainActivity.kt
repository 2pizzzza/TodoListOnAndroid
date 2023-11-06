package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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

        listView.setOnItemClickListener { parent, view, position, id ->
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Edit Item")

            val input = EditText(this)
            input.setText(todos[position])

            alertDialog.setView(input)

            alertDialog.setPositiveButton("OK") { dialog, which ->
                val newText = input.text.toString()
                if (newText.isNotEmpty()) {
                    todos[position] = newText
                    adapter.notifyDataSetChanged() // Обновите адаптер
                } else {
                    Toast.makeText(this, "Text cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

            alertDialog.setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }

            alertDialog.show()
        }


        button.setOnClickListener {
            val text = nameFields.text.toString().trim()
            if (nameFields.text.toString().isNotEmpty()){
                adapter.insert(text, 0)
            }
                Toast.makeText(this, "Fields connot be empty", Toast.LENGTH_SHORT).show()
        }

    }
}
//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            val text = listView.getItemAtPosition(i).toString()
//            adapter.remove(text)
//
//            Toast.makeText(this, "You delete task", Toast.LENGTH_LONG).show()
//        }
