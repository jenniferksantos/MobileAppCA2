package com.example.mobileapps1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapps1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent.getStringArrayExtra("name")
        val emailText = intent.getStringArrayExtra("email")

        binding.profileName.text = "Hi,$name"
        binding.profileEmail.text = "Your email is$emailText"

        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.viewPager.pageMargin = 20

        binding.bookNow.setOnClickListener{
            val i = Intent( this, BookingActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("email",emailText)

            startActivity(i)
        }


    }
}