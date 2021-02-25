package com.example.recyclerviewwithcardview


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.GenericTransitionOptions.with
import com.example.recyclerviewwithcardview.databinding.ActivityBigPhotoBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class BigPhoto : AppCompatActivity() {
    lateinit var binding: ActivityBigPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBigPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val path: String? = bundle?.getString("resId")

        Picasso.get().load(path).into(binding.imagePhotoProduct)


        binding.back.setOnClickListener {
            finish()
        }
    }

}