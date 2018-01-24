package com.tutsplus.myapplication

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import processing.android.PFragment
import processing.core.PApplet
import processing.core.PConstants


class MainActivity : AppCompatActivity() {

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
                stroke(Color.BLACK)
                fill(Color.WHITE)
                rect(100f, 100f, 500f, 300f)
                ellipse(350f, 650f, 500f, 400f)
                rect(100f, 900f, 500f, 300f, 100f)

                stroke(Color.GREEN)
                fill(Color.BLUE)
                triangle(100f, 1600f, 300f, 1300f, 500f, 1600f)

                // Check if user is touching the canvas
                if(mousePressed) {
                    // Specify fill and stroke colors
                    stroke(Color.RED)
                    fill(Color.YELLOW)

                    // Draw rectangle
                    rect(mouseX.toFloat(), mouseY.toFloat(), 100f, 100f)
                }
            }
        }

        val myFragment = PFragment(myCanvas)
        myFragment.setView(canvas_container, this)
    }
}
