package com.example.recyclerviewwithcardview

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewwithcardview.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), MainActivityContract.View{
    lateinit var binding: ActivityMainBinding
    lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)

        binding.back.setOnClickListener {
            val intent = Intent(this, OneProductActivity::class.java)
            startActivity(intent)
        }
        binding.basket.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java)
            startActivity(intent)
        }
    }

    override fun updateList(list: List<Product>) {
        binding.recyclerView.adapter = ProductAdapter(this, object : OnUserClick {
            override fun onUserClick(product: Product) {
                binding.root.setBackgroundColor(Color.YELLOW)
            }

            override fun onUserClick1(product: Product) {      //binding.root.setBackgroundColor(Color.GREEN)
                //val intent = Intent(this, OneProductActivity::class.java)
                //startActivity(intent)
                val intent = Intent(this@MainActivity, OneProductActivity::class.java)
                //intent.putParcelableArrayListExtra("data", product)
                //intent.putExtra("position", position)
                startActivity(intent)
            }


            override fun onUserClick2(product: Product) {
                binding.root.setBackgroundColor(Color.CYAN)
            }
        }, list).also { binding.recyclerView.adapter = it }

    }

    override fun showError(t: Throwable) {

    }

    override fun onResume() {
        super.onResume()
        presenter.getProductData()
    }

}