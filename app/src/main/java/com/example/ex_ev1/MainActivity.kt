package com.example.ex_ev1

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.ex_ev1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawable = getDrawable(R.drawable.vector)


        binding.etUserEmail?.setCompoundDrawablesWithIntrinsicBounds(drawable,null, null, null)

        var nombre: String? = null
        var apellidos: String? = null
        var email: String? = null
        var contraseña: String? = null
        var titulo: String? = null


        var formulario: Formulario;
        formulario = Formulario(nombre, apellidos, email, contraseña, titulo)




        binding.aceptar.setOnClickListener() {

            binding.aceptar.text= "Validado"
            binding.aceptar.setBackgroundColor(Color.parseColor("#88C68B"))

            if (binding.fp.isChecked) {
                formulario.nombre = binding.editTextName.text.toString()
                formulario.apellidos = binding.apellidostext.text.toString()
                formulario.email = binding.editTextEmail.text.toString()
                formulario.contraseña = binding.textocon?.text.toString()
                formulario.titulo = binding.fp.text.toString()
                formulario = ((Formulario( formulario.nombre, formulario.apellidos,   formulario.email, formulario.contraseña, formulario.titulo)as? Formulario)!!)

               showalert(formulario)


               /*     val intent = Intent(this, MainActivity2::class.java);
                    intent.putExtra("Formulario", "Datos del alumno :\n $formulario")


                startActivity(intent)*/
            }



            if (binding.certificado.isChecked) {
                formulario.nombre = binding.editTextName.text.toString()
                formulario.apellidos = binding.apellidostext.text.toString()
                formulario.email = binding.editTextEmail.text.toString()
                formulario.contraseña = binding.textocon?.text.toString()

                formulario.titulo = binding.certificado.text.toString()

                formulario = ((Formulario( formulario.nombre, formulario.apellidos,   formulario.email, formulario.contraseña, formulario.titulo)as? Formulario)!!)

                showalert(formulario)

            /*    val intent = Intent(this, MainActivity2::class.java);
                intent.putExtra("Formulario", "Datos del alumno :  \n $formulario")
                startActivity(intent)
*/
            }
            if (binding.master.isChecked) {

                formulario.nombre = binding.editTextName.text.toString()
                formulario.apellidos = binding.apellidostext.text.toString()
                formulario.email = binding.editTextEmail.text.toString()
                formulario.contraseña = binding.textocon?.text.toString()

                formulario.titulo = binding.master.text.toString()

                formulario = ((Formulario( formulario.nombre, formulario.apellidos,   formulario.email, formulario.contraseña, formulario.titulo)as? Formulario)!!)

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
            binding.textocon?.text=null
            binding.textocontraseA2?.text=null


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

    data class Formulario (
        var nombre: String?,
        var apellidos: String?,
        var email: String?,
        var contraseña: String?,
        var titulo: String?


    ) :Serializable {
        override fun toString(): String {


            return "- $nombre \n -$apellidos\n - $email \n - $contraseña \n - $titulo"
        }

    }

    private fun showalert(formulario: Formulario) {

        val alert = AlertDialog.Builder(this)

        alert.setTitle(R.string.Confirmacion)
        alert.setMessage(R.string.Desea_validar)



        alert.setPositiveButton(R.string.si) { dialog, which ->
         /*   var toast = Toast.makeText(this, R.string.Validado, Toast.LENGTH_SHORT)
            toast.show()*/

            if(binding.roundUpSwitch?.isChecked==true){
                val intent = Intent(this, MainActivity2::class.java);
                intent.putExtra("Formulario",  formulario)
                startActivity(intent)
            }else{
                var toast = Toast.makeText(this, R.string.Aceptarpolitica, Toast.LENGTH_SHORT)
                toast.show()
            }





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


