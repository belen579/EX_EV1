package com.example.ex_ev1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_ev1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombre: String? = null
        var apellidos: String? = null
        var email: String? = null
        var contraseña: String? = null
        var titulo: String? = null


        var formulario: Formulario;
        formulario = Formulario(nombre, apellidos, email, contraseña, titulo)
        formulario.nombre = binding.editTextName.text.toString()
        formulario.apellidos = binding.apellidostext.text.toString()
        formulario.email = binding.editTextEmail.text.toString()
        formulario.contraseña = binding.editTextEmail.text.toString()



        binding.aceptar.setOnClickListener() {

            if (binding.fp.isChecked) {
                formulario.titulo = binding.fp.text.toString()

               showalert(formulario)


               /*     val intent = Intent(this, MainActivity2::class.java);
                    intent.putExtra("Formulario", "Datos del alumno :\n $formulario")


                startActivity(intent)*/
            }



            if (binding.certificado.isChecked) {

                formulario.titulo = binding.certificado.text.toString()

                showalert(formulario)

            /*    val intent = Intent(this, MainActivity2::class.java);
                intent.putExtra("Formulario", "Datos del alumno :  \n $formulario")
                startActivity(intent)
*/
            }
            if (binding.master.isChecked) {

                formulario.titulo = binding.master.text.toString()

                showalert(formulario)

          /*       val intent = Intent(this, MainActivity2::class.java);

                intent.putExtra(
                    "Formulario", "Datos del alumno :" +
                            "\n $formulario"
                )
                startActivity(intent)*/

            }

        }

        binding.btnborrar?.setOnClickListener(){

            binding.editTextName.text=null

            binding.apellidostext.text=null
            binding.editTextEmail.text=null
            binding.textocontraseA.text=null
            binding.textocontraseA2.text=null


            binding.certificado.isChecked= false
            binding.fp.isChecked= false
            binding.master.isChecked= false

            binding.recordar.isChecked = false

            Snackbar.make(binding.btnborrar!!, "Datos Borrados", Snackbar.LENGTH_SHORT).show()

        }


        binding.calculardora?.setOnClickListener(){
            val intent = Intent(this, MainActivityCalculadora::class.java);

            startActivity(intent)
        }


    }

    data class Formulario(
        var nombre: String?,
        var apellidos: String?,
        var email: String?,
        var contraseña: String?,
        var titulo: String?
    ) {

        override fun toString(): String {
            return "Nombre: $nombre , \n Apellidos: $apellidos,\n email: $email, \n contraseña :$contraseña \n Titulo: $titulo"
        }


    }

    private fun showalert(formulario: Formulario) {

        val alert = AlertDialog.Builder(this)

        alert.setTitle("confirmacion")
        alert.setMessage("¿Desea validar los datos?")

        alert.setPositiveButton(R.string.si) { dialog, which ->
            var toast = Toast.makeText(this, R.string.Validado, Toast.LENGTH_SHORT)
            toast.show()


            val intent = Intent(this, MainActivity2::class.java);
            intent.putExtra("Formulario", "Datos del alumnos $formulario ")
            startActivity(intent)


            dialog.dismiss()
        }

        alert.setNegativeButton(R.string.no) { dialog, which ->
            var toast = Toast.makeText(this, R.string.cancelado, Toast.LENGTH_SHORT)
            toast.show()
            dialog.dismiss()


            val intent = Intent(this, MainActivity::class.java);

            startActivity(intent)

        }


        alert.create()
        alert.show()






    }
}