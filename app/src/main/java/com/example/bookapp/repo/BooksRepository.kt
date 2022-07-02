package com.example.booksapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookapp.room.BookDao
import com.example.booksapp.api.RetrofitAPI
import com.example.booksapp.model.Book
import kotlinx.coroutines.*

class BooksRepository(val dao : BookDao) {
    val retrofit = RetrofitAPI()
    private var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }
    var booksList = MutableLiveData<List<Book>>()



    suspend fun insertBook(book: Book) {
        dao.insertBook(book)
    }

    suspend fun getBook(id: Int) {
        dao.getBook(id)
    }

    fun getBooks(): LiveData<List<Book>> {
        return dao.getBooks()
    }

    suspend fun deleteBook(book: Book) {
        dao.deleteBook(book)
    }

    fun getBook() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = retrofit.api.getData()
            if (response.isSuccessful) {
                response.body()?.books?.let {
                    booksList.postValue(it)
                }
            }
        }

    }
}