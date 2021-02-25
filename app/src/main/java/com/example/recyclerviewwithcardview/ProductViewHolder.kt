package com.example.recyclerviewwithcardview

import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithcardview.databinding.RecyclerItemBinding
import com.squareup.picasso.Picasso

class ProductViewHolder(val view: View) :RecyclerView.ViewHolder(view) {
    private val binding: RecyclerItemBinding = RecyclerItemBinding.bind(itemView)
            fun bind(product: Product, callback: OnUserClick){
                binding.previousPrice.text = product.previousPrice
                binding.previousPrice.setPaintFlags(binding.previousPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                binding.newPrice.text = product.newPrice
                binding.textDescription.text = product.descriptionProduct
                Picasso.get().load(product.imageProductUrl).into(binding.productImageView)
                binding.newPrice.setOnClickListener{
                    callback.onUserClick(product)
                }
                binding.productImageView.setOnClickListener{
                    callback.onUserClick1(product)
                }
                binding.textDescription.setOnClickListener{
                    callback.onUserClick2(product)
                }
            }
}