package com.example.bookapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booksapp.model.Book

@Database(entities = [Book::class],version = 1,exportSchema = false)
abstract class BookDatabase : RoomDatabase()  {
    abstract fun bookDao() : BookDao

    companion object {

        @Volatile
        var INSTANCE: BookDatabase? = null



        fun getDatabaseInstance(context: Context): BookDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val roomDatabaseInstance = Room.databaseBuilder(
                    context, BookDatabase::class.java,
                    "notes"
                ).allowMainThreadQueries().build()

                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }

    }
}