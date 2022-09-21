package com.example.bookapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookapp.repo.LoginRepository

class SingInViewModel : ViewModel() {

    private var repository = LoginRepository()


    fun signIn(email: String,password : String){
        repository.signIn(email,password)
    }
}