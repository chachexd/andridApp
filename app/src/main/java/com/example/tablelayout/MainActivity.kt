package com.example.tablelayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtén el nombre de usuario que se pasó desde LoginActivity
        val username = intent.getStringExtra("username")

        val txtTextoInformacion = findViewById<TextView>(R.id.txtTextoInformacion)
        txtTextoInformacion.text = "Bienvenido, $username"
    }
}

