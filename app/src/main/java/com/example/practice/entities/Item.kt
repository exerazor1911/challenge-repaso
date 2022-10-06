package com.example.practice.entities

class Item(titulo: String?, subtitulo: String?, imagen : String?) {
    var titulo = ""
    var subtitulo = ""
    var imagen = ""
    init {
        this.titulo = titulo!!
        this.subtitulo = subtitulo!!
        this.imagen = imagen!!
    }

}