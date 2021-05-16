package com.example.todolist_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_1.R
import com.example.todolist_1.data.ItemList


class ItemAdapter(val items:List<ItemList>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val cbItem = itemView.findViewById<CheckBox>(R.id.CBitem)
        fun bind(item:ItemList){
            cbItem.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutId = R.layout.item
        return ItemViewHolder(itemView = inflater.inflate(layoutId, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}