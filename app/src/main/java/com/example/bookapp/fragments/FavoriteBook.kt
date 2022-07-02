package com.example.booksapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.adapter.FavoriteAdapter
import com.example.bookapp.databinding.FavoriteBookBinding
import com.example.booksapp.viewmodel.BooksViewModel
import com.google.android.material.snackbar.Snackbar


class FavoriteBook: Fragment(R.layout.favorite_book) {

    var fragmentBinding : FavoriteBookBinding? = null
    val viewModel : BooksViewModel by viewModels()
    var adapter : FavoriteAdapter? = null

    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectBook = adapter!!.favoriteList.get(layoutPosition)
            viewModel.deleteBook(selectBook)
            Snackbar.make(view!!,"Kitap Silindi",Snackbar.LENGTH_SHORT).setAction("Geri Al"){
                viewModel.insertBook(selectBook)
            }.show()
        }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FavoriteBookBinding.bind(view)
        fragmentBinding = binding

        binding.favoriteRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.bookList.observe(viewLifecycleOwner, Observer {
            adapter = FavoriteAdapter(it)
            binding.favoriteRecyclerView.adapter = adapter

            ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding.favoriteRecyclerView)

        })
    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}