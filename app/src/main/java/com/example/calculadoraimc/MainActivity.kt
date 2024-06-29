package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btCalculate.setOnClickListener {
            val i = Intent(this, ResultActivity::class.java)

            val peso = binding.editWeight.text.toString()
            val altura = binding.editHeight.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()) {
                i.putExtra("peso", peso.toDouble())
                i.putExtra("altura", altura.toDouble())
            }
            startActivity(i)
        }
    }
}