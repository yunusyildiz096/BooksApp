package com.example.bookapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapp.databinding.BookItemBinding
import com.example.booksapp.model.Book

open class BooksAdapter(private val listener : Listener) : RecyclerView.Adapter<com.example.bookapp.adapter.BooksAdapter.DataViewHolder>(){
    var bookList: ArrayList<Book> = ArrayList()
    var bookListFiltered: ArrayList<Book> = ArrayList()

    inner class DataViewHolder(val binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Book) {
            binding.bookName.text = result.bookName
            binding.bookPrice.text = "${result.bookPrice} TL"
            Glide.with(binding.root).load(result.bookİmageUrl).into(binding.bookImage)
            binding.bookMore.setOnClickListener {
                listener.onItemClick(result)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DataViewHolder{
        val recyclerBinding = BookItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(recyclerBinding)
    }


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int = bookListFiltered.size

    fun addData(list: List<Book>) {
        bookList = list as ArrayList<Book>
        bookListFiltered = bookList
        notifyDataSetChanged()
    }

    interface  Listener{
        fun onItemClick(book: Book)

    }

}
