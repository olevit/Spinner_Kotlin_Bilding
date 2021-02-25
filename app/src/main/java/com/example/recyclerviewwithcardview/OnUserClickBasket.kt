package com.example.recyclerviewwithcardview

interface OnUserClickBasket {
    fun onUserClickPlus(basketProduct: BasketProduct)
    fun onUserClickMinus(basketProduct: BasketProduct)
    fun onUserClickDelete(basketProduct: BasketProduct)
}