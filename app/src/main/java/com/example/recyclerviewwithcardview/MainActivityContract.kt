package com.example.recyclerviewwithcardview

import java.time.temporal.TemporalQuery

interface MainActivityContract {
    interface Presenter{
        fun getProductData()
    }
    interface View{
        fun updateList(list: List<Product>)
        fun showError(t:Throwable)
    }
}