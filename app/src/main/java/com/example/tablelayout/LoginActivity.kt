package com.example.tablelayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val edtUsername = findViewById<TextInputEditText>(R.id.edtUsername)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()

            if (username.isNotEmpty()) {
                // Redirige al MainActivity y pasa el nombre de usuario
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                finish()  // Cierra LoginActivity
            } else {
                Toast.makeText(this, "Por favor ingresa un nombre de usuario", Toast.LENGTH_SHORT).show()
            }
        }
        val btnCancel = findViewById<Button>(R.id.btnCancelar)
        btnCancel.setOnClickListener {
            // Cerrar la aplicación al presionar "Cancelar"
            finishAffinity() // Esto cierra todas las actividades y termina la app
        }
    }
}
