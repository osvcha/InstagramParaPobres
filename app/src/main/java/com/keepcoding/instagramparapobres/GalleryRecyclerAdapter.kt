package com.keepcoding.instagramparapobres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keepcoding.instagramparapobres.databinding.GalleryItemBinding
import com.keepcoding.instagramparapobres.gallery.Image
import com.keepcoding.instagramparapobres.utils.getDateTimeFromTimeStamp

class GalleryRecyclerAdapter(val clickListener: ListImagesClickListener) : RecyclerView.Adapter<GalleryViewHolder>() {

    interface ListImagesClickListener {
        fun listImagesClicked(image: Image)
    }

    var imageList: List<Image> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder =
        GalleryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { GalleryViewHolder(this) }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(imageList[position])
        holder.binding.morePhotosIcon.setOnClickListener {
            clickListener.listImagesClicked(imageList[position])
        }
    }

    override fun getItemCount(): Int = imageList.size

}

data class GalleryViewHolder(val binding: GalleryItemBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(image: Image) {
        with(binding) {
            titleTextView.text = image.title ?: "No title"
            authorTextView.text = image.author ?: "Unknown"
            dateTextView.text = getDateTimeFromTimeStamp(image.datetime)//image.datetime.toString()
            imageView.setImageBitmap(null)

            morePhotosIcon.isVisible = (image.imagesCount>1)

            authorAvatarImageView.setImageBitmap(null)
            Glide.with(root).load(image.url).into(imageView)
            Glide.with(root).load(image.authorAvatar).also {
                it.circleCrop()
            }.into(authorAvatarImageView)
        }
    }
}