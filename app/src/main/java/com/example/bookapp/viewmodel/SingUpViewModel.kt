package com.example.booksapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookapp.repo.LoginRepository

class SingUpViewModel : ViewModel() {

    private var repository = LoginRepository()

    fun signUp(email : String,password : String,userName : String){
        repository.signUp(email,password,userName)
    }
}