package com.example.ex_ev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ex_ev1.databinding.ActivityMainCalculadoraBinding


class MainActivityCalculadora : AppCompatActivity(), View.OnClickListener {

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



        binding.btcero?.setOnClickListener(this)
        binding.btuno?.setOnClickListener(this)
        binding.btdos?.setOnClickListener(this)
        binding.bttres?.setOnClickListener(this)
        binding.btcuatro?.setOnClickListener(this)
        binding.btcinco?.setOnClickListener(this)
        binding.btseis?.setOnClickListener(this)
        binding.btsiete?.setOnClickListener(this)
        binding.btocho?.setOnClickListener(this)
        binding.btnueve.setOnClickListener(this)
        binding.btcoma.setOnClickListener(this)
        binding.btmul.setOnClickListener(this)


        binding.btdiv.setOnClickListener(this)


        binding.btmenos.setOnClickListener(this)


        binding.btclear.setOnClickListener(this)



        binding.btplus.setOnClickListener(this)



        binding.btigual.setOnClickListener(this)

            // colocarnumeros( binding.btplus!!.text.toString())

            // onequalpressed()



    }

        override fun onClick(view: View) {
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

                binding.btplus ->onOperationPressed("+")
                binding.btigual-> onequalpressed()
                binding.btclear -> binding.screen.text= " "
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

        val resultado= when(operation){
            "+" -> firstnumber + secondnumbre
            "-" -> firstnumber - secondnumbre
            "*" -> firstnumber * secondnumbre
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



