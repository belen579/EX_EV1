package com.example.ex_ev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ex_ev1.databinding.ActivityMainCalculadoraBinding


class MainActivityCalculadora : AppCompatActivity(){

    private var firstnumber = 0.0
    private var secondnumbre = 0.0
    private var operation: String? = null

    private lateinit var binding: ActivityMainCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calculadora)

        binding = ActivityMainCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btcero?.setOnClickListener() { numeropresionado("0")}
        binding.btuno.setOnClickListener(){numeropresionado("1")}
        binding.btdos.setOnClickListener(){numeropresionado("2")}
        binding.bttres.setOnClickListener(){numeropresionado("3")}
        binding.btcuatro.setOnClickListener(){numeropresionado("4")}
        binding.btcinco.setOnClickListener(){ numeropresionado("5")}
        binding.btseis.setOnClickListener(){ numeropresionado("6")}
        binding.btsiete.setOnClickListener(){ numeropresionado("7")}
        binding.btocho.setOnClickListener(){numeropresionado("8")}
        binding.btnueve.setOnClickListener(){ numeropresionado("9")}
        binding.btcoma.setOnClickListener(){  numeropresionado(".")}

        binding.btmul.setOnClickListener(){onOperationPressed("*")}
        binding.btdiv.setOnClickListener(){ onOperationPressed("/")}
        binding.btmenos.setOnClickListener(){ onOperationPressed("-")}

        binding.btplus.setOnClickListener(){ onOperationPressed("+")}
        binding.btigual.setOnClickListener(){ onequalpressed()}
        binding.btclear.setOnClickListener(){oneclearpressed()}

    }

    private fun numeropresionado(number: String) {

        colocarnumeros(number)
        operacion()
    }

    private fun colocarnumeros(number: String) {


            val pantallaTexto = binding.screen.text.toString()

            // Verifica si la pantalla muestra solo "0" y el número no es un punto
            val resultado = if (pantallaTexto == "0" && number != ".") {
                number
            } else {
                "$pantallaTexto$number"
            }

            binding.screen.text = resultado
        }




    private fun operacion() {
        if (operation == null)
            firstnumber = binding.screen.text.toString().toDoubleOrNull()!!
        else
            secondnumbre = binding.screen.text.toString().toDoubleOrNull()!!

    }

    private fun onOperationPressed(operation:String){
        this.operation = operation
        firstnumber = binding.screen.text.toString().toDoubleOrNull() ?: 0.0
        binding.screen.text = "0"
    }

    private fun onequalpressed() {

        val resultado = when (operation) {
            "+" -> firstnumber + secondnumbre
            "-" -> firstnumber - secondnumbre
            "*" -> firstnumber * secondnumbre
            "/" -> firstnumber / secondnumbre
            else -> 0.0
        }

        operation = null
        firstnumber = resultado.toDouble()


        try {

            binding.screen.text = if (resultado.toString().endsWith(".0")) {
                resultado.toString().replace(".0", "")
            } else {
                "%.2f".format(resultado)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    private fun oneclearpressed() {
        binding.screen.text= ""
        firstnumber =0.0
        secondnumbre =0.0
    }


}



