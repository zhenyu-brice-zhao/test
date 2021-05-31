package com.example.todolist_1.data
import java.io.Serializable
class ListToDo (var titreList: String = "", var lesItems: MutableList<ItemToDo> = mutableListOf<ItemToDo>()) : Serializable {

    fun findItem(descriptionItem : String): Boolean {
        for (item in lesItems) {
            if (item.description == descriptionItem) {
                return true
            }
        }
        return false
    }

    fun addItem(unItem : ItemToDo) {
        lesItems.add(unItem)
    }

    fun updateItem(unItem : ItemToDo) {
        var updatedItem : MutableList<ItemToDo> = mutableListOf()
        for (item : ItemToDo in lesItems) {
            if (item.description == unItem.description) {
                updatedItem.add(unItem)
            }
            else {
                updatedItem.add(item)
            }
        }
        lesItems = updatedItem
    }

    override fun toString(): String = "Liste $titreList composé de $lesItems"

}
