package com.example.tablelayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar el nombre de usuario pasado desde LoginActivity
        val username = intent.getStringExtra("username")

        // Mostrar el nombre de usuario en el TextView
        val txtTextoInformacion = findViewById<TextView>(R.id.txtTextoInformacion)
        txtTextoInformacion.text = "Bienvenido, $username"  // Asignamos el texto con el nombre del usuario

        // Configurar ViewPager y TabLayout
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        // Crear y asignar el adaptador del ViewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        // Conectar el TabLayout con el ViewPager
        tabLayout.setupWithViewPager(viewPager)

        // Asignar iconos a las pestañas
        tabLayout.getTabAt(0)?.setIcon(R.drawable.baseline_contacts_24)  // Reemplaza con tu icono de Home
        tabLayout.getTabAt(1)?.setIcon(R.drawable.baseline_email_24)  // Reemplaza con tu icono de Settings
    }
}


