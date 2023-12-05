package com.example.ex_ev1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val intent = intent
        val textorecibido = intent.getStringExtra("Formulario")

        val textView = findViewById<TextView>(R.id.finaltextview)
        textView.text=textorecibido
    }
}