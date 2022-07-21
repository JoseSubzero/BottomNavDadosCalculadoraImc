package com.example.bottomnavdadoscalculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.bottomnavdadoscalculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.opDados -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.dadosFragment)
                    true
                }
                R.id.opCalculadora -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.calculadoraFragment)
                    true
                }
                R.id.opIMC ->{
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.IMCFragment)
                    true
                }
                else -> false
            }
        }
    }
}