package com.example.mobileapps1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapps1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val t = binding.root
        setContentView(t) //binding main layout to this activity?

        binding.createButton.setOnClickListener {
            val name = binding.nameText.text.toString()
            val emailText = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()

            // Validates inserted data
            if (name.isBlank() || emailText.isBlank())
                Toast.makeText(this, "Please fill the required fields", Toast.LENGTH_LONG).show()

            else if (password.length < 8) {
                Toast.makeText(this, "Password too short", Toast.LENGTH_LONG).show()
                binding.passwordText.setText("")
            }
            else if (!emailText.endsWith(".com", false)) {
                Toast.makeText(this, "Invalid E-mail", Toast.LENGTH_LONG).show()
                binding.emailText.error = "Invalid E-mail"

            }
            else {
                val intent = Intent( this, SecondActivity::class.java)

                intent.putExtra("name", name)
                intent.putExtra("email", emailText)

                startActivity(intent)
                finish()
            }
        }
    }

}