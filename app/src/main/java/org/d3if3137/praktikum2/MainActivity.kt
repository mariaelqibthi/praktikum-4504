package org.d3if3137.praktikum2

//import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3137.praktikum2.main.MainAdapter

class MainActivity : AppCompatActivity() { //mod4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate dijalankan")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart dijalankan")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume dijalankan")
    }
    override fun onPause() {
        Log.i("MainActivity", "onPause dijalankan")
        super.onPause()
    }
    override fun onStop() {
        Log.i("MainActivity", "onStop dijalankan")
        super.onStop()
    }
    override fun onDestroy() {
        Log.i("MainActivity", "onDestroy dijalankan")
        super.onDestroy()
    }
}