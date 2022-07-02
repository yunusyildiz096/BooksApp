package com.example.bookapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.booksapp.model.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM book ")
     fun getBooks() : LiveData<List<Book>>


    @Query("SELECT * FROM book WHERE id = :bookId")
    suspend fun getBook(bookId : Int) : Book

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book : Book)

    @Delete
    suspend fun deleteBook(book: Book)

}