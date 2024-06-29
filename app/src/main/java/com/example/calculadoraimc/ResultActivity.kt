package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private val binding: ActivityResultBinding by lazy {
        ActivityResultBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textPeso = binding.textPeso
        val textAltura = binding.textAltura
        val textResult = binding.textResult

        val bundle = intent.extras
        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso Kg"
            textAltura.text = "Altura informada: $altura M"

            val imc = peso / (altura * altura)

            val resultado = if (imc < 18.5) {
                "Abaixo do peso"
            } else if (imc in 18.5..24.9) {
                "Peso ideal"
            } else if (imc in 25.0..29.9) {
                "Sobrepeso"
            } else {
                "Obeso"
            }
            textResult.text = resultado
        }
    }
}