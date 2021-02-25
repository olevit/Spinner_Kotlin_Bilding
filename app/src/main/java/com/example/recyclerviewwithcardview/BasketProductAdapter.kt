package com.example.recyclerviewwithcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithcardview.databinding.RecyclerItemBasketBinding
import com.example.recyclerviewwithcardview.databinding.RecyclerItemProductBinding
import com.squareup.picasso.Picasso

class BasketProductAdapter (private val context: Context, private val callback: OnUserClickBasket,
                            private val basketProducts: List<BasketProduct>):
        RecyclerView.Adapter<BasketProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item_basket, parent, false))
    }
    override fun getItemCount() = basketProducts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val basketProduct = basketProducts[position]
        holder.bind(basketProduct, callback)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: RecyclerItemBasketBinding = RecyclerItemBasketBinding.bind(itemView)
        fun bind(basketProduct: BasketProduct, callback: OnUserClickBasket) {
            Picasso.get().load(basketProduct.imageProductUrl).into(binding.basketImageView)
            binding.minus.setOnClickListener {
                callback.onUserClickMinus(basketProduct)
            }
            binding.plus.setOnClickListener {
                callback.onUserClickPlus(basketProduct)
            }
            binding.delete.setOnClickListener{
                callback.onUserClickDelete(basketProduct)
            }
        }
    }
}
