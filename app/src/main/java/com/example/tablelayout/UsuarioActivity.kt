package com.example.tablelayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        // Botón para cerrar la actividad
        val btnCerrar = findViewById<Button>(R.id.btnCerrar)
        btnCerrar.setOnClickListener {
            // Cerrar la actividad cuando se haga clic en el botón
            finish()
        }
    }
}
