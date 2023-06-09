package com.example.escalacarona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.escalacarona.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edNome = binding.personName
        val edsenha = binding.senha
        val btLogin = binding.buttonEntrar

        btLogin.setOnClickListener {
            if(edNome.text.toString()=="Alexandre" && edsenha.text.toString()=="ale") {
                val inten = Intent(this, MainActivity2::class.java)
                val texto = edNome.text.toString()
                inten.putExtra("nome", texto)
                startActivity(inten)

                //testando escrita com banco de dados
                /*val database = Firebase.database
                val myRef = database.getReference("message")

                myRef.setValue("Hello, Word! Teste")*/
            }
            else{
                Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
            }
        }
        //setContentView(R.layout.activity_main)
    }
}