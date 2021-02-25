package com.example.recyclerviewwithcardview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewwithcardview.databinding.ActivityOneProductBinding
import com.squareup.picasso.Picasso
import java.util.*


class OneProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityOneProductBinding
    private var count:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityOneProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewProduct.adapter = OneProductAdapter(this, object : OnUserClickMiniPhoto {
            override fun onUserClickMiniPhoto(miniPhoto: OneProductMiniPhoto) {
                val intent = Intent(this@OneProductActivity, BigPhoto::class.java)
                intent.putExtra("resId", miniPhoto.imageMiniProductUrl)
                startActivity(intent)
            }
        }, createMiniPhotos()).also { binding.recyclerViewProduct.adapter = it }
        spinnerColor()
        spinnerSize()
                /*val arrayListSize = arrayListOf<String>("Size", "S", "M", "L", "XL", "XXL")
        val arrayAdapterSize = ArrayAdapter(applicationContext, R.layout.spinner, arrayListSize)
        arrayAdapterSize.also { binding.sizes.adapter = it }
        val arrayListColor = arrayListOf<String>("Color", "White", "Black", "Green", "Pink")
        val arrayAdapterColor = ArrayAdapter(applicationContext, R.layout.spinner, arrayListColor)
        binding.colors.adapter = arrayAdapterColor*/
        //binding.textProductDescription.text = binding.colors.selectedItemPosition.toString()

        Picasso.get().load("https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000")
            .into(binding.photoProduct)

        binding.photoProduct.setOnClickListener {
            val intent = Intent(this, BigPhoto::class.java)
            intent.putExtra("resId", "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000")
            startActivity(intent)
        }
        binding.back.setOnClickListener{
            finish()
        }
        binding.basket.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java)
            startActivity(intent)
        }
        binding.plus.setOnClickListener(this::addNumberProduct)
        binding.minus.setOnClickListener(this::subtractNumberProduct)
        binding.addToCart.setOnClickListener(this::addToCart)
    }

    private fun createMiniPhotos(): List<OneProductMiniPhoto> {
        val miniPhoto = ArrayList<OneProductMiniPhoto>()
        miniPhoto.add(OneProductMiniPhoto(
                "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000"))
        miniPhoto.add(OneProductMiniPhoto(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpy5jgPBVMUiM2IHkGhaB7xP8lshdZMrOsrA&usqp=CAU"))
        miniPhoto.add(OneProductMiniPhoto(
                "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000"))
        miniPhoto.add(OneProductMiniPhoto(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpy5jgPBVMUiM2IHkGhaB7xP8lshdZMrOsrA&usqp=CAU"))
        return miniPhoto
    }
    private fun spinnerColor(){
        val arrayListColor = arrayListOf<String>("Color", "White", "Black", "Green", "Pink")
        val arrayAdapterColor = ArrayAdapter(applicationContext, R.layout.spinner, arrayListColor)
        binding.colors.adapter = arrayAdapterColor
    }
    private fun spinnerSize(){
        val arrayListSize = arrayListOf<String>("Size", "S", "M", "L", "XL", "XXL")
        val arrayAdapterSize = ArrayAdapter(applicationContext, R.layout.spinner, arrayListSize)
        binding.sizes.adapter = arrayAdapterSize
    }
    private fun addNumberProduct(view: View){
        binding.count.text ="${++count}"
    }
    private fun subtractNumberProduct(view: View){
        if(count > 1) {
            binding.count.text = "${--count}"
        }
    }
    private fun addToCart(view: View){
        val intent = Intent(this, BasketActivity::class.java)
        startActivity(intent)
    }
}