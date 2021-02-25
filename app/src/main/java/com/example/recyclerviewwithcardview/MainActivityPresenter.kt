package com.example.recyclerviewwithcardview

import java.util.ArrayList

class MainActivityPresenter (private val view: MainActivityContract.View) :
        MainActivityContract.Presenter {

    override fun getProductData(){
        val productList = ArrayList<Product>()
        productList.add(Product("https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000", "$189.00", "$219", "Description"))
        productList.add(Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpy5jgPBVMUiM2IHkGhaB7xP8lshdZMrOsrA&usqp=CAU", "$179.00", "$199.00", "Description2"))
        productList.add(Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU", "$169.00", "$189.00", "Description3"))
        productList.add(Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR19AQcA89PsDQB_n4P4s9T9K1p_nLlB-I5kQ&usqp=CAU", "$159.00", "$179.00", "Description4"))
    view.updateList(productList)
    }
}