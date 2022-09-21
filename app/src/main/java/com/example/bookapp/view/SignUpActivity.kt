package com.example.bookapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bookapp.MainActivity
import com.example.bookapp.R
import com.example.bookapp.databinding.ActivitySignUpBinding
import com.example.booksapp.fragments.SignIn
import com.example.booksapp.viewmodel.SingUpViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    val viewModel : SingUpViewModel by viewModels()
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth
        val currentUser = auth.currentUser

        if (currentUser != null){
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.apply {
            singUpBtn.setOnClickListener {
                val email = editTextEmail.editText!!.text.toString()
                val password = editTextPassword.editText!!.text.toString()
                val userName = editTextUserName.editText!!.text.toString()
                if (email.isNotEmpty() || password.isNotEmpty() || userName.isNotEmpty()){
                    viewModel.signUp(email, password, userName)

                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            goToSignIn.setOnClickListener {
                val intent = Intent(this@SignUpActivity,SignIn::class.java)
                startActivity(intent)
                finish()
            }
            }
        }
    }
