package org.d3if3137.praktikum2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import org.d3if3137.praktikum2.databinding.ActivityMainBinding
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{ hitungBmi()}
    }

    private fun hitungBmi() {
        val berat = binding.beratEditText.text.toString().toFloat()
        val tinggi = binding.tinggiEditText.text.toString().toFloat() / 100
        val bmi = berat / (tinggi * tinggi)

        val selectedId = binding.radioGroup.checkedRadioButtonId
        val isMale = selectedId == R.id.priaRadioButton
        val kategori = getKategori(bmi, isMale)

        binding.bmiTextView.text = getString(R.string.bmi_x, bmi)
        binding.kategoriTextView.text = getString(R.string.kategori_x, kategori)

    }

    private fun getKategori(bmi: Float, isMale: Boolean): String {
        val stringRes = if (isMale){
            when {
                bmi < 20.5 -> R.string.kurus
                bmi >= 27.0 -> R.string.gemuk
                else -> R.string.ideal
            }
        }else {
            when {
                bmi < 20.5 -> R.string.kurus
                bmi >= 27.0 -> R.string.gemuk
                else -> R.string.ideal
            }
        }
        return getString(stringRes)
    }
}