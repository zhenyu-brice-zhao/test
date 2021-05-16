package com.example.todolist_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOk = findViewById<Button>(R.id.btn_ok)
        val etPseudo = findViewById<EditText>(R.id.et_name)

        btnOk.setOnClickListener{
            Toast.makeText(this@MainActivity, "Click on the ok", Toast.LENGTH_LONG).show()

            //preference

            //change to the second activity
            val iChoixListA:Intent = Intent(this, ChoixListActivity::class.java)
            startActivity(iChoixListA)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

}