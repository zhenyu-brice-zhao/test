package com.example.todolist_1.data
import java.io.Serializable
class ProfilListToDo (var login : String = "") : Serializable {

    var mesListeToDo : MutableList<ListToDo> = mutableListOf()

    constructor(log: String, mesListes: MutableList<ListToDo>) : this() {
        login = log
        mesListeToDo = mesListes
    }

    constructor(mesListes: MutableList<ListToDo>) : this(){
        login = "anonymous"
        mesListeToDo = mesListes
    }

    fun addListe(uneListe : ListToDo) {
        mesListeToDo.add(uneListe)
    }

    // Add unItem to the list uneListe if it is present in mesListeToDo
    fun addItem(uneListe: ListToDo?, unItem : ItemToDo) {
        var updatedListes : MutableList<ListToDo> = mutableListOf()
        for (list : ListToDo in mesListeToDo) {
            if (list.titreList == uneListe!!.titreList) {
                list.addItem(unItem)
                uneListe.addItem((unItem))
            }
            updatedListes.add(list)
        }
        mesListeToDo = updatedListes
    }

    // Update unItem from the list uneListe
    fun updateItem(uneListe: ListToDo?, unItem : ItemToDo) {
        var updatedListes : MutableList<ListToDo> = mutableListOf()
        for (list : ListToDo in mesListeToDo) {
            if (list.titreList == uneListe!!.titreList) {
                list.updateItem(unItem)
                uneListe.updateItem((unItem))
            }
            updatedListes.add(list)
        }
        mesListeToDo = updatedListes
    }

    // Check if a list with the given title already exists
    fun listAlreadyExists(title : String) : Boolean {
        for (list : ListToDo in mesListeToDo) {
            if (list.titreList == title) {
                return true
            }
        }
        return false
    }

    override fun toString(): String = "Listes du profil $login : $mesListeToDo"



}
