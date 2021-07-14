package com.pelegrino.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        alturaedt?.doAfterTextChanged { text ->
            // Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoedt?.doOnTextChanged { text, _, _, _ ->
            // imctext.text = text
        }
        calcularbtn?.setOnClickListener {
            calcularimc(pesoedt.text.toString(), alturaedt.text.toString())
        }
    }
    
    private fun calcularimc(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            imctext.text = "Seu imc é $imc".format(imc)
        }
    }
}