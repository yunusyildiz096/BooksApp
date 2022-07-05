package com.example.booksapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookapp.repo.LoginRepository

class SingUpViewModel : ViewModel() {

    private var repository = LoginRepository()

    fun singUp(email : String,password : String,userName : String){
        repository.singUp(email,password,userName)
    }
}