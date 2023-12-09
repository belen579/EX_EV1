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
        val textorecibido = intent?.getSerializableExtra("Formulario")as? MainActivity.Formulario

        val textView = findViewById<TextView>(R.id.finaltextview)
        if (textorecibido != null) {
            textView.text="Nombre :"+textorecibido.nombre.toString() +"\n" + "Apellidos :"+ textorecibido.apellidos.toString()+"\n"+ "Email :"+ textorecibido.email.toString()+"\n"+
                    "Contraseña :" +textorecibido.contraseña.toString()+"\n" +"Titulo :" +textorecibido.titulo.toString()
        }
    }
}