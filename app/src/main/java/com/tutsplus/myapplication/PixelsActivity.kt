package com.tutsplus.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import processing.android.PFragment
import processing.core.PApplet

class PixelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val myCanvas = object: PApplet() {
            override fun settings() {
                fullScreen()
            }

            override fun setup() {
                background(Color.parseColor("#FF8A80")) // Material Red A100
            }

            override fun draw() {
                loadPixels() // Load array

                // loop through all the coordinates
                for(y in 0..height - 1) {
                    for(x in 0..width - 1) {

                        // Calculate index
                        val index = x + y * width

                        // Update pixel at index with a new color
                        pixels[index] = Color.rgb(x % 255, y % 255, (x*y) % 255)
                    }
                }

                // Render pixels with new colors
                updatePixels()
            }
        }

        val myFragment = PFragment(myCanvas)
        myFragment.setView(canvas_container, this)
    }
}
