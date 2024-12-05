package com.example.tablelayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class informacionLegalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_legal)

        val btnAceptar = findViewById<Button>(R.id.btnAceptar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        val username = intent.getStringExtra("username") // Obtener nombre de usuario

        btnAceptar.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("username", username)
            resultIntent.putExtra("termsAccepted", "aceptado")  // Usuario acepta los términos
            setResult(RESULT_OK, resultIntent)  // Result OK
            finish()  // Regresar a MainActivity
        }

        btnCancelar.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("username", username)
            resultIntent.putExtra("termsAccepted", "rechazado")  // Usuario rechaza los términos
            setResult(RESULT_OK, resultIntent)  // Result OK
            finish()  // Regresar a MainActivity
        }
    }
}
