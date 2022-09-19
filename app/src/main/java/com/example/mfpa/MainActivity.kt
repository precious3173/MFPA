package com.example.mfpa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mfpa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)

        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?

        val navController = navHostFragment!!.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

      binding.navView.setupWithNavController(navController)
    }

}