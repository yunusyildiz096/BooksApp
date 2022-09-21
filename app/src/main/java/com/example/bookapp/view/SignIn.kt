package com.example.booksapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapp.MainActivity
import com.example.bookapp.databinding.SignInBinding
import com.example.bookapp.view.SignUpActivity
import com.example.booksapp.viewmodel.SingUpViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn: AppCompatActivity() {

    private lateinit var binding : SignInBinding
    val viewModel : SingUpViewModel by viewModels()
    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth
        val current = auth.currentUser
        if(current != null){
            val intent = Intent(this@SignIn,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.apply {
            singInBtn.setOnClickListener {
                val email = editTextMail.editText!!.text.toString()
                val password = editTextPassword.editText!!.text.toString()
                if (email.isNotEmpty() || password.isNotEmpty()){
                    viewModel.signUp(email, password,null.toString())
                    val intent = Intent(this@SignIn,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            goToSignUp.setOnClickListener {
                val intent = Intent(this@SignIn,SignUpActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    }