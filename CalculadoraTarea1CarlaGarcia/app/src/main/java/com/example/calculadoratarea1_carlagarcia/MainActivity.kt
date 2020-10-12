package com.example.calculadoratarea1_carlagarcia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            startActivity(
                Intent(this, Calculadora::class.java).putExtra(
                    "Nombre",
                    txtNombre.text.toString()
                ).putExtra("Apellido", txtApellido.text.toString())
            )


        }
        btnExit.setOnClickListener {
            val cerrarApp: Intent = Intent(this, finish()::class.java)


        }


    }
}