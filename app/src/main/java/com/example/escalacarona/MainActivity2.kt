package com.example.escalacarona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.escalacarona.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioNome = binding.passaNome
        val nome = intent.getStringExtra("nome")
        usuarioNome.text = nome
        //setContentView(R.layout.activity_tela2)

        val btCadastrarMotorista = binding.botaoCadastrarViagem

        btCadastrarMotorista.setOnClickListener{
            var intenDois = Intent(this, MainActivity3::class.java)

            startActivity(intenDois)
        }

        val btListarViagens = binding.buttonListarViagem

        btListarViagens.setOnClickListener{
            var telaQuatro = Intent(this, MainActivity4::class.java)

            startActivity(telaQuatro)
        }

    }
}