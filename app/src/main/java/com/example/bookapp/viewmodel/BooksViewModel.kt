package com.example.booksapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.bookapp.room.BookDatabase
import com.example.booksapp.model.Book
import com.example.booksapp.repo.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(application: Application) : AndroidViewModel(application) {

    val repository : BooksRepository

    var _reponse = MutableLiveData<List<Book>>()
    val getBooks : LiveData<List<Book>>
        get() = _reponse

    init {
        val dao = BookDatabase.getDatabaseInstance(application).bookDao()
        repository = BooksRepository(dao)
    }
    val bookList = repository.dao.getBooks()



    fun getAllBooks(){
         repository.getBook()
        _reponse = repository.booksList
    }

    fun insertBook(book: Book) = viewModelScope.launch {
        repository.dao.insertBook(book)

        }
    fun deleteBook(book: Book) = viewModelScope.launch {
        repository.dao.deleteBook(book)
    }


}
