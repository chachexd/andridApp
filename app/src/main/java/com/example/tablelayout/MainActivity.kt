package com.example.tablelayout

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var txtTextoInformacion: TextView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var fabInfo: FloatingActionButton
    private lateinit var fabUsuario: FloatingActionButton
    private lateinit var fabHobbie: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar el nombre de usuario pasado desde LoginActivity
        val username = intent.getStringExtra("username") ?: "Usuario desconocido" // Manejo de nulos

        // Mostrar el nombre de usuario en el TextView
        txtTextoInformacion = findViewById(R.id.txtTextoInformacion)
        txtTextoInformacion.text = "Bienvenido, $username" // Mostrar "Bienvenido, nombre_usuario"

        // Configurar TabLayout y ViewPager
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewpager)

        // Crear el adaptador del ViewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // Añadir los fragmentos al adaptador
        adapter.addFragment(FirstFragment(), "Home")
        adapter.addFragment(SecondFragment(), "Settings")

        // Asignar el adaptador al ViewPager
        viewPager.adapter = adapter

        // Conectar el TabLayout con el ViewPager
        tabLayout.setupWithViewPager(viewPager)

        // Opcional: agregar iconos a las pestañas
        tabLayout.getTabAt(0)?.setIcon(R.drawable.baseline_contacts_24)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.baseline_email_24)

        // Configurar el FAB para abrir los términos legales


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main , menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val username = intent.getStringExtra("username") ?: "Usuario desconocido" // Recuperar el nombre del usuario
        return when (item.itemId) {
            R.id.fabInfo -> {
                // Ejecutar la actividad de Información Legal
                val intent = Intent(this, informacionLegalActivity::class.java)
                intent.putExtra("username", username) // Pasar el nombre del usuario real
                startActivityForResult(intent, 1)
                true
            }
            R.id.fabUsuario -> {
                // Ejecutar la actividad de Usuario
                val intent = Intent(this, UsuarioActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.fabHobbie -> {
                // Ejecutar la actividad de Hobbie
                val intent = Intent(this, HobbieActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    // Recibir los resultados de InformacionLegalActivity (aceptación de términos)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("ActivityResult", "requestCode: $requestCode, resultCode: $resultCode")

        if (data != null) {
            Log.d("ActivityResult", "username: ${data.getStringExtra("username")}")
            Log.d("ActivityResult", "termsAccepted: ${data.getStringExtra("termsAccepted")}")
        }

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val username = data?.getStringExtra("username") ?: "Usuario desconocido"
            val acceptedTerms = data?.getStringExtra("termsAccepted") ?: "rechazado"
            txtTextoInformacion.text = "$username ha $acceptedTerms los términos legales"
        } else {
            val username = data?.getStringExtra("username") ?: "Usuario desconocido"
            txtTextoInformacion.text = "$username no ha aceptado los términos legales"
        }
    }

}
