package com.example.booksapp.api

import com.example.bookapp.model.Books
import com.example.booksapp.model.Book
import retrofit2.Response
import retrofit2.http.GET

interface BookAPI {
    //http://books.canerture.com/all_books.php
    @GET("/all_books.php")
    suspend fun getData() : Response<Books>
}