package com.example.mobileapps1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapps1.databinding.ActivityBookingBinding

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        binding.dungeons.setOnClickListener{
            moveNext("Dungeons & Dragons", 1)
        }
        binding.johnWick.setOnClickListener{
            moveNext("John Wick - Chapter 4",2)
        }
        binding.air.setOnClickListener{
            moveNext("Air - Courting a legend", 3)
        }
        binding.renfield.setOnClickListener{
            moveNext("Renfield",4)
        }
    }

    private fun moveNext(name: String, num : Int) {
        if (name.isNotBlank()){
            val i = Intent( this, Ticket::class.java)
            i.putExtra("movieName", name)
            i.putExtra("movieNumber",num)

            startActivity(i)
        }
        else {
            Toast.makeText(this, "Movie name is empty", Toast.LENGTH_LONG).show()
        }
    }
}