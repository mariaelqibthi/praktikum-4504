package org.d3if3137.praktikum2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mariaelqibthi.hitungbmi.model.HasilBmi
import com.mariaelqibthi.hitungbmi.model.KategoriBmi
import org.d3if3137.hitungbmi.ui.MainViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}
