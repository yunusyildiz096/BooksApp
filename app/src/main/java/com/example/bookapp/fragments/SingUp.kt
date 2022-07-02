package com.example.booksapp.fragments

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bookapp.R
import com.example.bookapp.databinding.SingUpBinding
import com.example.booksapp.viewmodel.SingUpViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SingUp : Fragment(R.layout.sing_up) {

    private var fragmentBinding : SingUpBinding? = null
    val viewModel : SingUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = SingUpBinding.bind(view)
        fragmentBinding = binding

        binding.apply {
            singUpBtn.setOnClickListener {
                val email = editTextEmail.editText!!.text.toString()
                val password = editTextPassword.editText!!.text.toString()
                val userName = editTextUserName.editText!!.text.toString()
                if (email.isNotEmpty() || password.isNotEmpty() || userName.isNotEmpty()){
                    viewModel.singUp(email, password, userName)
                    findNavController().navigate(SingUpDirections.actionSingUpToBooksItem())
                }
            }
            goToSingIn.setOnClickListener {
                findNavController().navigate(SingUpDirections.actionSingUpToSingIn())
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

    }
