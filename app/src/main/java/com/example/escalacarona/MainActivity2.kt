package com.example.escalacarona

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
    }
}