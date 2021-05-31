package com.example.todolist_1

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_1.adapter.ChoixAdapter
import com.example.todolist_1.adapter.ItemAdapter
import com.example.todolist_1.data.ItemToDo
import com.example.todolist_1.data.ListToDo
import com.example.todolist_1.data.ProfilListToDo
import com.google.gson.Gson

class ShowListActivity: AppCompatActivity(),ItemAdapter.ActionListener{
    var pos:Int=0

    var item_name : MutableList<ItemToDo> = mutableListOf()
    var recyclerview: RecyclerView? = null
    var sp : SharedPreferences? = null
    var oldprofil: ProfilListToDo? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showlist)
        recyclerview = findViewById<RecyclerView>(R.id.listofitem)
        var bundle = intent.extras
        if (bundle != null) {
            pos = bundle.getInt("Pos")
        }
        sp = getSharedPreferences("pref",MODE_PRIVATE)
        val DefaultSerialLists = "{\"login\":\"DefaultName\",\"mesListeToDo\":[]}"

        //Retirer l'objet json dans la préférence
        val sharelists:String? = sp?.getString("Lists", DefaultSerialLists)
        oldprofil = Gson().fromJson(sharelists.toString(), ProfilListToDo::class.java)
        Log.i("Info", ""+oldprofil?.mesListeToDo?.size)
//        val listname:String? = oldprofil?.mesListeToDo?.get(pos)?.titreList
//        if(listname==null){
//            this.title = "no_name"
//        }else{
//            this.title = listname
//        }
        //Afficher les Items
        recyclerview?.adapter = oldprofil?.mesListeToDo?.get(pos)?.lesItems?.let { ItemAdapter(it,this) }
        recyclerview?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }

    override fun onStart() {
        super.onStart()
        val btnOk = findViewById<Button>(R.id.BtnShowList)
        val etNewList = findViewById<EditText>(R.id.ShowListInput)
        btnOk.setOnClickListener{
            val et_new: Editable? = etNewList.text
            var item = ItemToDo(et_new.toString())
            item_name.add(item)
            recyclerview?.adapter = ItemAdapter(item_name, this)
            recyclerview?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

            oldprofil?.mesListeToDo?.get(pos)?.addItem(item)
            with (sp?.edit()) {
                this?.putString("Lists", Gson().toJson(oldprofil))
                this?.apply()
            }
        }
    }

    override fun onItemChanged(pos_list: Int) {
        oldprofil?.mesListeToDo?.get(pos)?.lesItems?.get(pos_list)?.fait = !oldprofil?.mesListeToDo?.get(pos)?.lesItems?.get(pos_list)?.fait!!
    }


}