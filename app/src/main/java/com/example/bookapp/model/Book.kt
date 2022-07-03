package com.example.booksapp.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "book")
data class Book(
    @ColumnInfo(name = "bookauthor")
    @SerializedName("book_author")
    @Expose
    var bookAuthor: String?,
    @ColumnInfo(name = "bookname")
    @SerializedName("book_name")
    @Expose
    var bookName: String?,
    @ColumnInfo(name = "bookprice")
    @SerializedName("book_price")
    @Expose
    var bookPrice: String?,
    @ColumnInfo(name = "bookpublisher")
    @SerializedName("book_publisher")
    @Expose
    var bookPublisher: String?,
    @SerializedName("book_id")
    @Expose
    var bookİd: Int? = null,
    @ColumnInfo(name = "bookimageurl")
    @SerializedName("book_image_url")
    @Expose
    var bookİmageUrl: String?,

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null

)