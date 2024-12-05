package com.example.tablelayout
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tablelayout.R

class informacionLegalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_legal)

        val btnAceptar = findViewById<Button>(R.id.btnAceptar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        // Obtén el nombre de usuario pasado desde LoginActivity
        val username = intent.getStringExtra("username")

        btnAceptar.setOnClickListener {
            // Si acepta los términos, pasa el nombre de usuario a MainActivity
            val intent = Intent()
            intent.putExtra("username", username)  // Pasa el nombre de usuario
            setResult(RESULT_OK, intent)
            finish()  // Termina esta actividad y vuelve a LoginActivity
        }

        btnCancelar.setOnClickListener {
            // Si no acepta los términos, devuelve un resultado cancelado
            setResult(RESULT_CANCELED)
            finish()  // Termina esta actividad y vuelve a LoginActivity
        }
    }
}
