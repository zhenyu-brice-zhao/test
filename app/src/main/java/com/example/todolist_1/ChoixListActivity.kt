package com.example.todolist_1

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_1.adapter.ChoixAdapter

class ChoixListActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choixlist)
//        val btnOk = findViewById<Button>(R.id.BtnChoixList)
//        val etNewList = findViewById<EditText>(R.id.choixlist_input)
//        val recyclerview = findViewById<RecyclerView>(R.id.listofname)
//        val list_name : MutableList<String> = mutableListOf()
//
//
//        btnOk.setOnClickListener{
//            val et_new: Editable? = etNewList.text
//            list_name.add(et_new.toString())
//            recyclerview.adapter = ChoixAdapter(list_name)
//            recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        }

    }

    override fun onStart() {
        super.onStart()
        val btnOk = findViewById<Button>(R.id.BtnChoixList)
        val etNewList = findViewById<EditText>(R.id.choixlist_input)
        val recyclerview = findViewById<RecyclerView>(R.id.listofname)
        val list_name : MutableList<String> = mutableListOf()


        btnOk.setOnClickListener{
            val et_new: Editable? = etNewList.text
            list_name.add(et_new.toString())
            recyclerview.adapter = ChoixAdapter(list_name)
            recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        }

    }

}