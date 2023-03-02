package org.d3if3137.praktikum2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val hewan = listOf("Ayam", "Bebek", "Domba", "Kambing", "Sapi")
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener{ showNext() }
    }

    private fun showNext() {
        index = if (index == hewan.size-1) 0 else index + 1

        val imageView: ImageView = findViewById(R.id.imageView)
        val resourceId = when(index){
            1 -> R.drawable.bebek
            2 -> R.drawable.domba
            3 -> R.drawable.kambing
            4 -> R.drawable.sapi
            else -> R.drawable.ayam

        }
        val textView: TextView = findViewById(R.id.nameTextView)
        textView.text = hewan[index]
    }
}