package com.hilt.ui.imagelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hilt.ui.R
import com.hilt.ui.databinding.ListImageBinding
import com.hilt.ui.db.ImageEntity
import javax.inject.Inject

class ImageAdapter @Inject constructor() : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private var items = mutableListOf<ImageEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListImageBinding.inflate(inflater)
        return ImageViewHolder(binding)
    }

    fun setList(list: List<ImageEntity>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ImageViewHolder(private val binding: ListImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageEntity) {
//            binding.item = item
//            binding.executePendingBindings()
            //binding.imageView.context.toast(item.url)
            //https://i.picsum.photos/id/56/200/300.jpg?hmac=XmVgSk2B8hc9Smojh4o14JnHBHBM8Gj0ePS78sxZbzI
            Glide
                .with(binding.imageView.context)
                .load(item.downloadUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(binding.imageView)

        }
    }


}