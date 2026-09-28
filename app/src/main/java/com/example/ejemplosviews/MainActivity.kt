package com.example.ejemplosviews

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextName = findViewById<EditText>(R.id.editTextText)
        val btnSaludar = findViewById<Button>(R.id.button3)
        val btnLimpiar = findViewById<Button>(R.id.button2)
        val tvResultado = findViewById<TextView>(R.id.textView2)

        btnSaludar.setOnClickListener {
            val nombre = editTextName.text.toString()
            if (nombre.isNotBlank()) {
                tvResultado.text = "¡Hola, $nombre!"
            } else {
                tvResultado.text = "Por favor escribe un nombre"
            }
        }

        btnLimpiar.setOnClickListener {
            editTextName.setText("")
            tvResultado.text = ""
        }
    }
}
