package com.example.tablelayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity.RESULT_OK

class HobbieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        // Botón para cerrar la actividad
        val btnCerrar = findViewById<Button>(R.id.btnCerrar)
        btnCerrar.setOnClickListener {
            // Cerrar la actividad cuando se haga clic en el botón
            finish()
        }
    }
}
