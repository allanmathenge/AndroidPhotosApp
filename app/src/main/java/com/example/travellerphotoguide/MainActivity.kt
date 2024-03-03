package com.example.travellerphotoguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity: AppCompatActivity() {

    private var currentImage = 0
    private lateinit var image : ImageView
    private var places = arrayOf("Sky Moon", "Mombasa Beach", "Wild Cat", "Tsavo Eagles")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tvName)

        next.setOnClickListener{
            // Scroll to the next image
            var currentImageString = "pic$currentImage"

            // Get integer address associated with each design component
            var idCurrentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage+1)%4
            var idImageToSowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToSowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }

        prev.setOnClickListener{
            // Scroll to previous image
            var currentImageString = "pic$currentImage"

            // Get integer address associated with each design component
            var idCurrentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage-1)%4
            var idImageToSowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToSowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }
    }
}