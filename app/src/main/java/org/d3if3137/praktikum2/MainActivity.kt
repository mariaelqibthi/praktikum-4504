package org.d3if3137.praktikum2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
        index++
        val textView: TextView = findViewById(R.id.nameTextView)
        textView.text = hewan[index]
    }
}