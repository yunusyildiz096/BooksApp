package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragmentContainerView)
        setupBottomNavMenu(navController)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == R.id.singIn || destination.id == R.id.singUp ){
                bottomNavigationView.visibility = View.GONE
            }else{
                bottomNavigationView.visibility = View.VISIBLE
            }
        })

    }
    private fun setupBottomNavMenu(navController: NavController){

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.fragmentContainerView)) || super.onOptionsItemSelected(item)
    }

}