package com.example.tablelayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tablelayout.R
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
                val intent = Intent(this, informacionLegalActivity::class.java)
                intent.putExtra("username", username)  // Pasa el nombre de usuario
                startActivityForResult(intent, 1)
            } else {
                Toast.makeText(this, "Por favor ingresa un nombre de usuario", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Recibe el resultado de la actividad de aceptación de términos
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val username = data?.getStringExtra("username")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", username)  // Pasa el nombre de usuario a MainActivity
            startActivity(intent)
            finish()  // Cierra LoginActivity
        } else {
            // Si el usuario no acepta los términos, muestra un mensaje
            Toast.makeText(this, "No aceptaste los términos", Toast.LENGTH_SHORT).show()
        }
    }
}
