package com.example.todolist_1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.example.todolist_1.data.ProfilListToDo
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    var sp : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val btnOk = findViewById<Button>(R.id.btn_ok)
        val etPseudo = findViewById<EditText>(R.id.et_name)
        var editor:SharedPreferences.Editor? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = getSharedPreferences("pref",MODE_PRIVATE)


    }

    override fun onStart() {


        super.onStart()
        val btnOk = findViewById<Button>(R.id.btn_ok)
        val etPseudo = findViewById<EditText>(R.id.et_name)
        //On utilise SharePreference pour sauvegarder le dernier pseudo sur le champ de saisie
        val DefaultName = ""
        val DefaultSerialLists = "{\"login\":\"DefaultName\",\"mesListeToDo\":[]}"
        val SharePseudo: String? = sp?.getString("pseudo",DefaultName)
        val ShareLists: String? = sp?.getString("Lists", DefaultSerialLists)
        val spProfil:String = ShareLists.toString()
        Log.i("Info", SharePseudo)
        Log.i("Info", spProfil)
        etPseudo.setText(SharePseudo) // set the name saved before

        btnOk.setOnClickListener{

            //preference
            val pseudo = etPseudo!!.text.toString()

            var lastprofil = Gson().fromJson(spProfil,ProfilListToDo::class.java)
            Log.i("Info", lastprofil.login)
            if(pseudo==""){
                Toast.makeText(this@MainActivity, "Input your name", Toast.LENGTH_LONG).show()
            }
            else{
                var profilListToDo = ProfilListToDo(pseudo)
                Log.i("Info", Gson().toJson(profilListToDo))
                with (sp?.edit()) {
                    this?.putString("pseudo", pseudo.toString())
                    this?.apply()
                }
                if(lastprofil.login!=pseudo){
                    with (sp?.edit()) {
                        this?.putString("Lists", Gson().toJson(profilListToDo))
                        this?.apply()
                    }
                }


                val iChoixListA:Intent = Intent(this, ChoixListActivity::class.java)
                startActivity(iChoixListA)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when(id) {
            R.id.menu_setting -> {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
