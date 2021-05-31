package com.example.todolist_1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_1.adapter.ChoixAdapter
import com.example.todolist_1.data.ListToDo
import com.example.todolist_1.data.ProfilListToDo
import com.google.gson.Gson

class ChoixListActivity:AppCompatActivity(),ChoixAdapter.ActionListener {
    var list_name : MutableList<String> = mutableListOf()
    var recyclerview: RecyclerView? = null
    var sp : SharedPreferences? = null
    var oldprofil: ProfilListToDo? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("pref",MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choixlist)
        recyclerview = findViewById<RecyclerView>(R.id.listofname)
        val DefaultSerialLists = "{\"login\":\"DefaultName\",\"mesListeToDo\":[]}"
        val sharelists:String? = sp?.getString("Lists", DefaultSerialLists)
        oldprofil = Gson().fromJson(sharelists.toString(), ProfilListToDo::class.java)
        Log.i("Info", sharelists)
        Log.i("Info", ""+oldprofil?.mesListeToDo?.size)
        for(list in oldprofil?.mesListeToDo!!){
            list_name.add(list.titreList)
        }
        recyclerview?.adapter = ChoixAdapter(list_name,this)
        recyclerview?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onStart() {
        super.onStart()
        val btnOk = findViewById<Button>(R.id.BtnChoixList)
        val etNewList = findViewById<EditText>(R.id.choixlist_input)



        btnOk.setOnClickListener{
            val et_new: Editable? = etNewList.text
            list_name.add(et_new.toString())
            recyclerview?.adapter = ChoixAdapter(list_name,this)
            recyclerview?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            oldprofil?.addListe(ListToDo(et_new.toString()))
            with (sp?.edit()) {
                this?.putString("Lists", Gson().toJson(oldprofil))
                this?.apply()
            }
        }

    }

//    fun ChoixItemOnClick(view: View){
//        val pos = recyclerView.getChildAdapterPosition(view)
//        Toast.makeText(this@ChoixListActivity, "Click "+pos, Toast.LENGTH_LONG).show()
//
//    }

    override fun onItemClicked(pos_list: Int, title: String) {
        //Toast.makeText(this@ChoixListActivity, "Click "+pos_list, Toast.LENGTH_LONG).show()
        val bundle:Bundle = Bundle()
        bundle.putInt("Pos", pos_list)
        val iToShowListActivity : Intent  = Intent(this@ChoixListActivity, ShowListActivity::class.java)
        iToShowListActivity.putExtras(bundle)
        startActivity(iToShowListActivity)
    }



}