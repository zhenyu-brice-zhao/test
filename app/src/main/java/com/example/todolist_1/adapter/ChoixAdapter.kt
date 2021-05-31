package com.example.todolist_1.adapter

import android.net.wifi.p2p.WifiP2pManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.todolist_1.R
import androidx.recyclerview.widget.RecyclerView

class ChoixAdapter(val choixList:List<String>,private val actionListener: ActionListener):RecyclerView.Adapter<ChoixAdapter.ChoixViewHolder>() {
    inner class ChoixViewHolder(choixView:View):RecyclerView.ViewHolder(choixView){
        val choix_name = choixView.findViewById<TextView>(R.id.list_name)
        fun bind(choix:String){
            choix_name.text = choix
        }
        init {
            choixView.setOnClickListener(){
                val pos = adapterPosition
                if(pos!=RecyclerView.NO_POSITION){
                    val title:String = choix_name.text as String
                    actionListener.onItemClicked(pos, title)
                    Log.i("Info", "click "+title)
                }
            }
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

    interface ActionListener{
        fun onItemClicked(pos_list:Int, title:String)

    }



}