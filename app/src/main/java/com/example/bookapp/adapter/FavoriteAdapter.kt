package com.example.bookapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapp.databinding.FavoriteItemBinding
import com.example.booksapp.model.Book

class FavoriteAdapter(val favoriteList: List<Book>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    class FavoriteViewHolder(val bindig : FavoriteItemBinding) : RecyclerView.ViewHolder(bindig.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val favoriteRecyclerView = FavoriteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoriteViewHolder(favoriteRecyclerView)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = favoriteList.get(position)
        holder.bindig.apply {
            fvtName.text = favorite.bookName
            fvtPrice.text = "${favorite.bookPrice} ₺"
            fvtAuthor.text = favorite.bookAuthor

            Glide.with(holder.itemView.context).load(favorite.bookİmageUrl).into(fvtImage)
        }
    }
    override fun getItemCount(): Int {
        return favoriteList.size
    }
}