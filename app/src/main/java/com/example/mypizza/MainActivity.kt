package com.example.mypizza

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.View.VISIBLE
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View.GONE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(this, R.id.homeNavHostFragment)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            when(destination.id){
                R.id.MainPage, R.id.search, R.id.configu -> {
                    bottom_nav.visibility=VISIBLE
                }
                else -> bottom_nav.visibility = GONE
            }
        }
        bottom_nav.setupWithNavController(navController)
    }



    }



