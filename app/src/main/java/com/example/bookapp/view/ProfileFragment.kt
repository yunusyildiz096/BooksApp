package com.example.booksapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.bookapp.R
import com.example.bookapp.databinding.ProfileFragmentBinding
import com.example.bookapp.view.SignUpActivity
import com.example.bookapp.viewmodel.ProfileViewModel

class ProfileFragment: Fragment(R.layout.profile_fragment) {
    var fragmentBinding : ProfileFragmentBinding? = null
    val viewModel : ProfileViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = ProfileFragmentBinding.bind(view)
        fragmentBinding = binding


        binding.apply {
             singOutBtn.setOnClickListener {
                viewModel.signOut()

                 val intent = Intent(activity,SignUpActivity::class.java)
                 activity!!.startActivity(intent)
                 activity!!.finish()
            }
            viewModel.userInfo.observe(viewLifecycleOwner, Observer {
               proMailText.text = it.email
               proNameText.text = it.userName

            })
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}