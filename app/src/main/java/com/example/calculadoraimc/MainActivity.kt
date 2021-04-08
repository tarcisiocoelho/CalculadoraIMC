package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainCadastrar.setOnClickListener {
            val altura = binding.edtMainAltura.text.toString().toFloat() / 100
            val peso   = binding.edtMainPeso.text.toString().toFloat()
            val res    = peso / (altura * altura)
            val formato = "%.2f".format(res)

            if(res < 18.5){
                binding.txvMainCalculo.text = "Seu IMC é $formato\n Você se encontra abaixo do peso."
            } else if(res > 18.5 && res < 24.9){
                binding.txvMainCalculo.text = "Seu IMC é $formato\n Peso normal."
            } else if(res > 25 && res < 29.9){
                binding.txvMainCalculo.text = "Seu IMC é $formato\n Você está sobrepeso."
            } else if(res > 30 && res < 39.9){
                binding.txvMainCalculo.text = "Seu IMC é $formato\n Você se encontra em obesidade."
            } else if(res > 40){
                binding.txvMainCalculo.text = "Seu IMC é $formato\n Você está em obesidade grave."
            } else {
                Toast.makeText(this, "Erro ao calcular", Toast.LENGTH_LONG).show()
            }
        }

    }
}