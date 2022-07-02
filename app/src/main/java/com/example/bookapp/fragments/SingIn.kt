package com.example.booksapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bookapp.R
import com.example.bookapp.databinding.SingInBinding
import com.example.bookapp.viewmodel.SingInViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SingIn: Fragment(R.layout.sing_in) {

    private var fragmentBinding : SingInBinding? = null
    val viewModel : SingInViewModel  by viewModels()
    private lateinit var auth : FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = SingInBinding.bind(view)
        fragmentBinding = binding
        auth = Firebase.auth

        binding.apply {
            singInBtn.setOnClickListener {
                val email = editTextMail.editText!!.text.toString()
                val password = editTextPassword.editText!!.text.toString()
                if (email.isNotEmpty() || password.isNotEmpty()){
                    viewModel.singIn(email, password)
                    findNavController().navigate(SingInDirections.actionSingInToBooksItem())
                }
            }
            goToSingUp.setOnClickListener {
                findNavController().navigate(SingInDirections.actionSingInToSingUp())
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}