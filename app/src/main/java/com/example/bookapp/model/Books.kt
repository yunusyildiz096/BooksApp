package com.example.bookapp.model

import com.example.booksapp.model.Book
import com.google.gson.annotations.SerializedName

class Books(@SerializedName("books")
              val books: List<Book>,
            @SerializedName("success")
              val success: Int)



