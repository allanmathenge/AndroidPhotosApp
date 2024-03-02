package com.example.travellerphotoguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)


        next.setOnClickListener{
            // Scroll to the next image
            var currentImageString = "pic$currentImage"

            // Get integer address associated with each design component
            var idCurrentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage+1)%5
            var idImageToSowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToSowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

        }

        prev.setOnClickListener{
            // Scroll to previous image
            var currentImageString = "pic$currentImage"

            // Get integer address associated with each design component
            var idCurrentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage-1)%5
            var idImageToSowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToSowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

        }
    }
}