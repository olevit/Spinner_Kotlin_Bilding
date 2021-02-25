package com.example.recyclerviewwithcardview


import java.io.Serializable

data class Product(val imageProductUrl: String, val newPrice: String, val previousPrice: String,
                   val descriptionProduct: String) : Serializable {
}
