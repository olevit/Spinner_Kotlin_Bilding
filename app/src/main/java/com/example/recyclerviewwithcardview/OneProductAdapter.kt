package com.example.recyclerviewwithcardview

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithcardview.databinding.RecyclerItemBinding
import com.example.recyclerviewwithcardview.databinding.RecyclerItemProductBinding
import com.squareup.picasso.Picasso

class OneProductAdapter(private val context: Context, private val callback: OnUserClickMiniPhoto,
                        private val miniPhotos: List<OneProductMiniPhoto>) : RecyclerView.Adapter<OneProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item_product, parent, false))
    }
    override fun getItemCount() = miniPhotos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val miniPhoto = miniPhotos[position]
        holder.bind(miniPhoto, callback)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: RecyclerItemProductBinding = RecyclerItemProductBinding.bind(itemView)
        fun bind(miniPhoto: OneProductMiniPhoto, callback: OnUserClickMiniPhoto) {
            Picasso.get().load(miniPhoto.imageMiniProductUrl).into(binding.productImageView)
            binding.productImageView.setOnClickListener {
                callback.onUserClickMiniPhoto(miniPhoto)
            }

        }
    }
}