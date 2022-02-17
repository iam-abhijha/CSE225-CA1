package com.mrtechy.cse225_ca1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.view.isVisible
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBar1 = findViewById<RatingBar>(R.id.p1Rating)
        ratingShow(ratingBar1)
        val ratingBar2 = findViewById<RatingBar>(R.id.p2Rating)
        ratingShow(ratingBar2)
        val ratingBar3 = findViewById<RatingBar>(R.id.p3Rating)
        ratingShow(ratingBar3)
        val ratingBar4 = findViewById<RatingBar>(R.id.p4Rating)
        ratingShow(ratingBar4)
        val ratingBar5 = findViewById<RatingBar>(R.id.p5Rating)
        ratingShow(ratingBar5)
        val ratingBar6 = findViewById<RatingBar>(R.id.p6Rating)
        ratingShow(ratingBar6)
        val ratingBar7 = findViewById<RatingBar>(R.id.p7Rating)
        ratingShow(ratingBar7)





        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val progressBtn = findViewById<Button>(R.id.progressBtn)

        progressBtn.setOnClickListener {

            Thread(Runnable {
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    progressBar.visibility = View.VISIBLE
                })

                try {
                    var i=0;
                    while(i<Int.MAX_VALUE/2){
                        i++
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, "Can't able to load", Toast.LENGTH_SHORT).show()
                })
            }).start()
        }

        val intentBtn = findViewById<Button>(R.id.intentBtn)
        intentBtn.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://abhi.mrtechy.in/")
            startActivity(intent)
        }


    }


    private fun ratingShow(ratingBar:RatingBar){

        val layout = layoutInflater.inflate(R.layout.toast,null)
        ratingBar.setOnRatingBarChangeListener { _, _, _ ->
            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_SHORT
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.view = layout
            myToast.show()

        }
    }
}


