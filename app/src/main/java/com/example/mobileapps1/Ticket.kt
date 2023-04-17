package com.example.mobileapps1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapps1.databinding.ActivityTicketBinding

class Ticket : AppCompatActivity() {
    private lateinit var binding: ActivityTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        //
        val movieName = intent.getStringExtra("movieName")
        binding.movieName.text = movieName

        val num = intent.getIntExtra("movieNumber", 1)

        when(num) { // Movie selected by user
            1 -> {
                binding.movieImage.setImageResource(R.drawable.dung_dragons)
                binding.movieDescription.text = " A charming thief and a band of unlikely adventurers undertake an epic heist to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people."
            }

            2 -> {
                binding.movieImage.setImageResource(R.drawable.john_wick)
                binding.movieDescription.text = " John Wick (Keanu Reeves) uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes."
            }

            3 -> {
                binding.movieImage.setImageResource(R.drawable.air)
                binding.movieDescription.text = " From award-winning director Ben Affleck, 'Air' reveals the unbelievable game-changing partnership between a then rookie Michael Jordan and Nike's fledgling basketball division which revolutionized the world of sports and contemporary culture."
            }

            4 -> {
                binding.movieImage.setImageResource(R.drawable.renfield)
                binding.movieDescription.text = " Evil doesn't span eternity without a little help. In this modern monster tale of Dracula's loyal servant, Nicholas Hoult stars as Renfield, the tortured aide to history's most narcissistic boss, Dracula (Oscar winner Nicolas Cage)."
            }

            else -> {
                Toast.makeText(this, "No movie found", Toast.LENGTH_LONG).show()
            }
        }

        //Shows confirmation message
        binding.confirmButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Success! YOu booked tickets for \n$movieName")

            //To show Ok button
            builder.setPositiveButton("OK"){ _, _ ->
                finish() //Ok button is closed after clicked
            }
            builder.create().show() // Dialogue box
        }
    }
}