package com.example.ex_ev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ex_ev1.databinding.ActivityMainCalculadoraBinding


class MainActivityCalculadora : AppCompatActivity() {

    private var firstnumber = 0.0
    private var secondnumbre = 0.0
    private var operation: String? = null

    private lateinit var binding: ActivityMainCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calculadora)

        binding = ActivityMainCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operation = null



        binding.btcero?.setOnClickListener() {


        }
        binding.btuno?.setOnClickListener() {
            colocarnumeros(binding.btuno!!.text.toString())
        }
        binding.btdos?.setOnClickListener() {
            colocarnumeros(binding.btdos!!.text.toString())
        }
        binding.bttres?.setOnClickListener() {
            colocarnumeros(binding.bttres!!.text.toString())
        }
        binding.btcuatro?.setOnClickListener() {
            colocarnumeros(binding.btcuatro!!.text.toString())
        }
        binding.btcinco?.setOnClickListener() {
            colocarnumeros(binding.btcinco!!.text.toString())
        }
        binding.btseis.setOnClickListener() {
            colocarnumeros(binding.btseis!!.text.toString())
        }
        binding.btsiete.setOnClickListener() {
            colocarnumeros(binding.btsiete!!.text.toString())
        }
        binding.btocho.setOnClickListener() {
            colocarnumeros(binding.btocho!!.text.toString())
        }
        binding.btnueve.setOnClickListener() {
            colocarnumeros(binding.btnueve!!.text.toString())
        }
        binding.btcoma.setOnClickListener() {
            colocarnumeros(binding.btcoma!!.text.toString())
        }
        binding.btmul.setOnClickListener() {
            colocarnumeros(binding.btmul!!.text.toString())
        }
        binding.btdiv.setOnClickListener() {
            colocarnumeros(binding.btdiv!!.text.toString())
        }
        binding.btmenos.setOnClickListener() {
            colocarnumeros(binding.btmenos!!.text.toString())
        }
        binding.btclear.setOnClickListener() {
            colocarnumeros(binding.btclear!!.text.toString())
        }

        binding.btplus.setOnClickListener() {
            colocarnumeros(binding.btplus!!.text.toString())
        }

        binding.btigual.setOnClickListener() {
            // colocarnumeros( binding.btplus!!.text.toString())

            // onequalpressed()
        }

        onClick(binding.btigual)
    }

        fun onClick(view: View) {
            when (view) {

                binding.btcero -> numeropresionado("0")
                binding.btuno -> numeropresionado("1")
                binding.btdos ->numeropresionado("2")
                binding.bttres -> numeropresionado("3")
                binding.btcuatro -> numeropresionado("4")
                binding.btcinco -> numeropresionado("5")
                binding.btseis -> numeropresionado("6")
                binding.btsiete -> numeropresionado("7")
                binding.btocho -> numeropresionado("8")
                binding.btnueve -> numeropresionado("9")
                binding.btcoma -> numeropresionado(",")
                binding.btmul ->onOperationPressed("*")
                binding.btdiv -> onOperationPressed("/")
                binding.btmenos -> onOperationPressed("-")
                binding.btclear -> numeropresionado("")
                binding.btplus ->onOperationPressed("*")
                binding.btigual-> onequalpressed()
            }
        }



    private fun numeropresionado(number: String) {

        colocarnumeros(number)
        operacion()
    }

    private fun colocarnumeros(number: String) {

        val resultado:String = if (binding.screen.text == "0" && number != ",")
            number
        else
            "${binding.screen.text} $number"

        binding.screen.text = resultado

    }

    private fun operacion() {
        if (operation == null)
            firstnumber = binding.screen.text.toString().toDouble()
        else
            secondnumbre = binding.screen.text.toString().toDouble()

    }

    private fun onOperationPressed(operation:String){
        this.operation = operation

        firstnumber = binding.screen.text.toString().toDouble()

        binding.screen.text ="0"
    }

    private fun onequalpressed(){

        val resultado:Double = when(operation){
            "+" -> firstnumber + secondnumbre
            "-" -> firstnumber - secondnumbre
            "x" -> firstnumber * secondnumbre
            "/" -> firstnumber / secondnumbre
            else -> 0.0
        }

        operation=null
        firstnumber = resultado.toDouble()

        binding.screen.text = if (resultado.toString().endsWith(".0")){
            resultado.toString().replace(".0","")
        }else{
            "%.2f".format(resultado)
        }

    }
}

