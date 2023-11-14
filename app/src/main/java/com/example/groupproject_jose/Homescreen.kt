package com.example.groupproject_jose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Homescreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.homescreen)

        val startButt = findViewById<Button>(R.id.startButton)
        startButt.setOnClickListener(){
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
            Toast.makeText(
                applicationContext,"Great!!", Toast.LENGTH_LONG
            )
                .show()
        }

    }
    private fun setUpclickListener(){

    }
}