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
        val nombre=getString( R.string.nombre)
        val apellidos =getString(R.string.apellidos)
        val contraseña = getString(R.string.contraseña)
        val titulo =getString(R.string.titulo)

        val textView = findViewById<TextView>(R.id.finaltextview)
        if (textorecibido != null) {
            textView.text="$nombre :"+ textorecibido.nombre.toString() +"\n" + "$apellidos :"+ textorecibido.apellidos.toString()+"\n"+ "Email :"+ textorecibido.email.toString()+"\n"+
                    "$contraseña :" +textorecibido.contraseña.toString()+"\n" +"$titulo :" +textorecibido.titulo.toString()
        }
    }
}