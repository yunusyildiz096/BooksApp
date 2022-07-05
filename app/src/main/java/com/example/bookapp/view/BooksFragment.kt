package com.example.booksapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.bookapp.R
import com.example.bookapp.adapter.BooksAdapter
import com.example.bookapp.databinding.BooksFragmentBinding
import com.example.booksapp.model.Book
import com.example.booksapp.viewmodel.BooksViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class BooksFragment : Fragment(R.layout.books_fragment),BooksAdapter.Listener {

    var fragmentBinding : BooksFragmentBinding? = null
    val viewModel : BooksViewModel by viewModels()
    var booksBooksAdapter : BooksAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = BooksFragmentBinding.bind(view)
        fragmentBinding = binding

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        viewModel.getAllBooks()
        viewModel.getBooks.observe(viewLifecycleOwner, Observer {
            booksBooksAdapter = BooksAdapter(this)
            binding.recyclerView.adapter = booksBooksAdapter
            renderPhotosList(it)

        })
    }

    override fun onItemClick(book: Book) {

        val bottomSheetDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
        val bottomImage = bottomSheetDialog.findViewById<ImageView>(R.id.bottomBookImage)
        val bottomBookName = bottomSheetDialog.findViewById<TextView>(R.id.bottomBookName)
        val bottomBookPrice = bottomSheetDialog.findViewById<TextView>(R.id.bottomBookPrice)
        val bottomBookPublisher = bottomSheetDialog.findViewById<TextView>(R.id.bottomBookPublisher)
        val bottomBookAuthor = bottomSheetDialog.findViewById<TextView>(R.id.bottomBookAuthor)
        val bottomButton = bottomSheetDialog.findViewById<Button>(R.id.bottomFavoriteBtn)

        Glide.with(requireContext()).load(book.bookİmageUrl).into(bottomImage!!)
        bottomBookName!!.text = book.bookName
        bottomBookPrice!!.text = "${book.bookPrice} ₺"
        bottomBookPublisher!!.text = book.bookPublisher
        bottomBookAuthor!!.text = book.bookAuthor

        bottomButton!!.setOnClickListener {
            bottomSheetDialog.dismiss()
            viewModel.insertBook(book)
            Toast.makeText(requireContext(),"${book.bookName} Eklendi",Toast.LENGTH_LONG).show()

        }
        bottomSheetDialog.show()
    }

    private fun renderPhotosList(photosList: List<Book>) {
        booksBooksAdapter!!.addData(photosList)
        booksBooksAdapter!!.notifyDataSetChanged()

    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}