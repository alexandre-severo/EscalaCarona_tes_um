package com.example.escalacarona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.escalacarona.databinding.ActivityMain3Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main3)

        var edData = binding.dataViagem
        var edCarum = binding.nomeCaroneiroUm
        var edcardois = binding.nomeCaroneiroDois
        var edcartre = binding.nomeCaroneiroTre
        var edcarqua = binding.nomeCaroneiroQua
        var edcarcin = binding.nomeCaroneiroCinc
        var botaoCadastrar = binding.btEnviarTelaCadas

        dbRef = FirebaseDatabase.getInstance().getReference("Viagens")

        botaoCadastrar.setOnClickListener{
            val empData = edData.text.toString()
            val empCaroneiroum = edCarum.text.toString()
            val empCaroneirodois = edcardois.text.toString()
            val empCaroneirotres = edcartre.text.toString()
            val empCaroneiroqua = edcarqua.text.toString()
            val empCaroneirocinc = edcarcin.text.toString()

            if(empData.isEmpty()){
                edData.error = "Por favor insira uma data"
            }
            if(empCaroneiroum.isEmpty()){
                edCarum.error = "Por favor insira um Caroneiro"
            }
            if(empCaroneirodois.isEmpty()){
                edcardois.error = "Por favor insira um Caroneiro"
            }
            if(empCaroneirotres.isEmpty()){
                edcartre.error = "Por favor insira um Caroneiro"
            }
            if(empCaroneiroqua.isEmpty()){
                edcarqua.error = "Por favor insira um Caroneiro"
            }
            if(empCaroneirocinc.isEmpty()){
                edcarcin.error = "Por favor insira um Caroneiro"
            }

            val empId = dbRef.push().key!!

            val viagens = ViagemModelo(empId, empData, empCaroneiroum, empCaroneirodois, empCaroneirotres, empCaroneiroqua, empCaroneirocinc)

            dbRef.child(empId).setValue(viagens)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edData.text.clear()
                    edCarum.text.clear()
                    edcardois.text.clear()
                    edcartre.text.clear()
                    edcarqua.text.clear()
                    edcarcin.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

    }
}