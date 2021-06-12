package com.keepcoding.instagramparapobres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keepcoding.instagramparapobres.databinding.DetailItemBinding
import com.keepcoding.instagramparapobres.gallery.Image

class ImagesRecyclerAdapter(var image: Image) : RecyclerView.Adapter<ImageListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder =
        DetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { ImageListViewHolder(this) }


    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        holder.bind(image.imagesUrls?.get(position) ?: "")
    }

    override fun getItemCount(): Int = image.imagesUrls?.size ?: 0


}

data class ImageListViewHolder(val binding: DetailItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String) {
        with(binding) {
            imageView.setImageBitmap(null)
            Glide.with(root).load(imageUrl).into(imageView)
        }
    }
}