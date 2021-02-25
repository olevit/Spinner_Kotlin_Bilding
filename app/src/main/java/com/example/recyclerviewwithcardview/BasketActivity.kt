package com.example.recyclerviewwithcardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.recyclerviewwithcardview.databinding.ActivityBasketBinding
import com.example.recyclerviewwithcardview.databinding.ActivityBigPhotoBinding
import java.util.ArrayList

class BasketActivity : AppCompatActivity(){
    lateinit var binding: ActivityBasketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBasketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayListShipping = arrayListOf<String>("Israel", "Turkey", "China")
        val arrayAdapterShipping = ArrayAdapter(applicationContext, R.layout.basket_spinner, arrayListShipping)
        binding.shipping.adapter = arrayAdapterShipping

        val arrayListPickUpShop = arrayListOf<String>("Pick up shop", "Post shipping")
        val arrayAdapterPickUpShop = ArrayAdapter(applicationContext, R.layout.basket_spinner, arrayListPickUpShop)
        binding.pickUpShop.adapter = arrayAdapterPickUpShop

        binding.recyclerView.adapter = BasketProductAdapter(this, object : OnUserClickBasket {
            override fun onUserClickMinus(basketProduct: BasketProduct) {
                TODO("Not yet implemented")
            }

            override fun onUserClickPlus(basketProduct: BasketProduct) {
                TODO("Not yet implemented")
            }

            override fun onUserClickDelete(basketProduct: BasketProduct) {
                TODO("Not yet implemented")
            }
        }, createBasketProduct()).also { binding.recyclerView.adapter = it }

        binding.back.setOnClickListener {
            finish()
        }
    }

    private fun createBasketProduct(): List<BasketProduct> {
        val basketProduct = ArrayList<BasketProduct>()
        basketProduct.add(BasketProduct("https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000",
                "$189.00", 1, "Description",false))
        basketProduct.add(BasketProduct("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpy5jgPBVMUiM2IHkGhaB7xP8lshdZMrOsrA&usqp=CAU",
                "$179.00",1,"Description1", false))
        basketProduct.add(BasketProduct("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU",
                "$169.00", 1, "Description2", false))
        return basketProduct
    }
}