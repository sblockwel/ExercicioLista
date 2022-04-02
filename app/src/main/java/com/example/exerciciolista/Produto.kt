package com.example.exerciciolista

data class Produto(
    val nome: String,
    val descricao: String = "",
    val valor: Double
) {
}