package org.d3if3137.praktikum2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import org.d3if3137.praktikum2.databinding.ActivityMainBinding
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.mariaelqibthi.hitungbmi.model.HasilBmi
import com.mariaelqibthi.hitungbmi.model.KategoriBmi


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{ hitungBmi()}
        viewModel.getHasilBmi().observe(this, {showResult(it)})
    }

    private fun hitungBmi() {
        val berat = binding.beratBadanInp.text.toString().toFloat()
        val tinggi = binding.tinggiBadanInp.text.toString().toFloat()
        val selectedId = binding.radioGroup.checkedRadioButtonId
        viewModel.hitungBmi(
            berat.toFloat(),
            tinggi.toFloat(),
            selectedId == R.id.priaRadioButton
        )
    }

    private fun getKategori(bmi: Float, isMale: Boolean): KategoriBmi {
        val kategori = if (isMale){
            when {
                bmi < 20.5 -> KategoriBmi.KURUS
                bmi >= 27.0 -> KategoriBmi.GEMUK
                else -> KategoriBmi.IDEAL
            }
        }else {
            when {
                bmi < 20.5 -> KategoriBmi.KURUS
                bmi >= 27.0 -> KategoriBmi.GEMUK
                else -> KategoriBmi.IDEAL
            }
        }
        return kategori
    }

    private fun getKategoriLabel(kategori: KategoriBmi): String {
        val stringRes = when (kategori) {
            KategoriBmi.KURUS -> R.string.kurus
            KategoriBmi.IDEAL -> R.string.ideal
            KategoriBmi.GEMUK -> R.string.gemuk
        }
    return getString(stringRes)
    }

    private fun hitungBmi(berat: Float, tinggi : Float, isMale: Boolean): HasilBmi {
        val tinggiCm = tinggi / 100
        val bmi = berat / (tinggiCm * tinggiCm)
        val kategori = getKategori(bmi, isMale)
        return HasilBmi(bmi, kategori)
    }

    private fun showResult(result: HasilBmi?){
        if (result == null) return
        binding.bmiTextView.text = getString(R.string.bmi_x, result.bmi)
        binding.kategoriTextView.text = getString(R.string.kategori_x, getKategoriLabel(result.kategori))
    }
}
