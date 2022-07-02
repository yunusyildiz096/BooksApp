package com.example.bookapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookapp.repo.LoginRepository

class SingInViewModel : ViewModel() {

    private var repository = LoginRepository()


    fun singIn(email: String,password : String){
        repository.singIn(email,password)
    }
}