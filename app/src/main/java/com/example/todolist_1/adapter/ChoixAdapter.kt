package com.example.todolist_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.todolist_1.R
import androidx.recyclerview.widget.RecyclerView

class ChoixAdapter(val choixList:List<String>):RecyclerView.Adapter<ChoixAdapter.ChoixViewHolder>() {
    class ChoixViewHolder(choixView:View):RecyclerView.ViewHolder(choixView){
        val choix_name = choixView.findViewById<TextView>(R.id.list_name)
        fun bind(choix:String){
            choix_name.text = choix
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoixViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutId = R.layout.choice_list
        return ChoixViewHolder(choixView = inflater.inflate(layoutId, parent, false))
    }


    override fun getItemCount(): Int = choixList.size

    override fun onBindViewHolder(holder: ChoixViewHolder, position: Int) {
        holder.bind(choixList[position])
    }


}