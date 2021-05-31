package com.example.todolist_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class SettingActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settingslayout, SettingsFragment())
            .commit()
    }


}