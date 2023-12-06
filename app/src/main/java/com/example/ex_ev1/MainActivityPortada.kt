package com.example.ex_ev1

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.URLUtil
import android.widget.Toast
import com.example.ex_ev1.databinding.ActivityMainBinding

import com.example.ex_ev1.databinding.ActivityMainPortadaBinding

class MainActivityPortada : AppCompatActivity() {

    private lateinit var binding: ActivityMainPortadaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_portada)


        binding = ActivityMainPortadaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btn.setOnClickListener() {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    fun openWebPage(context: Context, url: String?) {
        try {
            if (!URLUtil.isValidUrl(url)) {
                Toast.makeText(context, " This is not a valid link", Toast.LENGTH_LONG).show()
            } else {
                //OPCION1
                // val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url));

                //OPCION2
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)

                context.startActivity(intent)

            }
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                context,
                " You don't have any browser to open web page",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.share_action) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Pizzeria Pedido")
                type = "Text/plain"
            }
            try {
                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No se puede", Toast.LENGTH_SHORT).show()
            }
        }

        if (item.itemId == R.id.Inicio_app) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

        if (item.itemId == R.id.acerca) {
            Toast.makeText(this, "Realizado por Belén Bastos", Toast.LENGTH_SHORT).show()

        }

        if (item.itemId == R.id.Acceder_Web) {


            openWebPage(this, "https://en.wikipedia.org/wiki/Satellite_of_Love")


        }






        return true
    }




        }





