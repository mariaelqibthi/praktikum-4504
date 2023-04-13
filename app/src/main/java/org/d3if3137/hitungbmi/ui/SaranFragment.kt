package org.d3if3137.hitungbmi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mariaelqibthi.hitungbmi.model.KategoriBmi
import org.d3if3137.praktikum2.R
import org.d3if3137.praktikum2.databinding.FragmentHitungBinding
import org.d3if3137.praktikum2.databinding.FragmentSaranBinding
import java.util.zip.Inflater

class SaranFragment : Fragment() {
    private lateinit var binding: FragmentSaranBinding
    private val args: SaranFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSaranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun updateUI(kategori: KategoriBmi) {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        when (kategori) {
            KategoriBmi.KURUS -> {
                actionBar?.title = getString(R.string.judul_kurus)
                binding.imageView.setImageResource(R.drawable.kurus)
                binding.textView.text = getString(R.string.saran_kurus)
            }
            KategoriBmi.IDEAL -> {
                actionBar?.title = getString(R.string.judul_ideal)
                binding.imageView.setImageResource(R.drawable.ideal)
                binding.textView.text = getString(R.string.saran_ideal)
            }
            KategoriBmi.GEMUK -> {
                actionBar?.title = getString(R.string.judul_gemuk)
                binding.imageView.setImageResource(R.drawable.gemuk)
                binding.textView.text = getString(R.string.saran_gemuk)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUI(args.kategori)
    }
}