package com.example.saludapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.saludapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnShowName.setOnClickListener { checkValue() }
    }

    fun checkValue() {
        if (binding.etName.text.isNotEmpty()) {
            //Cambiamos la pantalla usando intent
            val intent = Intent (this, ResultActivity::class.java)
            intent.putExtra("INTENT_NAME", binding.etName.text)
            startActivity(intent)

        }
        else{
            //Mostramos un mensaje de error
            showErrorName()
        }

    }

    fun showErrorName(){
        Toast.makeText(this, "El nombre de usuario no puede estar vacio", Toast.LENGTH_SHORT).show()
    }
}