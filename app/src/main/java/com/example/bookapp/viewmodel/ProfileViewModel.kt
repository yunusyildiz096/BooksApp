package com.example.bookapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapp.model.Users
import com.example.bookapp.repo.LoginRepository

class ProfileViewModel : ViewModel() {
    private var repository = LoginRepository()

    var _userInfo = MutableLiveData<Users>()
    val userInfo : LiveData<Users>
    get() = _userInfo

    init {
        getUser()
    }

    private fun getUser(){
        repository.getUser()
        _userInfo = repository.userInfo
    }

    fun signOut(){
        repository.signOut()
    }

}