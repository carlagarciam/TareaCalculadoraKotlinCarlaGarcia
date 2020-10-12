package com.example.calculadoratarea1_carlagarcia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculadora.*


class Calculadora : AppCompatActivity() {
    private var num1: Int = 0
    private var num2: Int = 0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val objetoIntent: Intent = intent
        var Nombre = objetoIntent.getStringExtra("Nombre")
        var Apellido = objetoIntent.getStringExtra("Apellido")
        nombreA1.text = "Bienvenid@ $Nombre $Apellido"

        btn1.setOnClickListener { numeroPresionado("1") }
        btn2.setOnClickListener { numeroPresionado("2") }
        btn3.setOnClickListener { numeroPresionado("3") }
        btn4.setOnClickListener { numeroPresionado("4") }
        btn5.setOnClickListener { numeroPresionado("5") }
        btn6.setOnClickListener { numeroPresionado("6") }
        btn7.setOnClickListener { numeroPresionado("7") }
        btn8.setOnClickListener { numeroPresionado("8") }
        btn9.setOnClickListener { numeroPresionado("9") }
        btn9.setOnClickListener { numeroPresionado("0") }

        btnSumar.setOnClickListener { operacionPresionada(SUMA) }
        btnRestar.setOnClickListener { operacionPresionada(RESTA) }
        btnMultiplicar.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        btnDividir.setOnClickListener { operacionPresionada(DIVISION) }

        btnBorrar.setOnClickListener {
            num1 = 0
            num2 = 0
            resultadotextView.text = "0"
            operacion = SINOPERACION

        }

        btnIgual.setOnClickListener {
            var resultado = when (operacion) {

                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0

            }
            resultadotextView.text = resultado.toString()


        }
    }

    private fun numeroPresionado(digito: String) {

        resultadotextView.text = "${resultadotextView.text}$digito"

        if (operacion == SINOPERACION) {
            num1 = resultadotextView.text.toString().toInt()
        } else {

            num2 = resultadotextView.text.toString().toInt()
        }
    }

    private fun operacionPresionada(operacion: Int) {
        this.operacion = operacion
        num1 = resultadotextView.text.toString().toInt()
        resultadotextView.text = "0"
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SINOPERACION = 0
    }
}