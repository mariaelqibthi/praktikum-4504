package org.d3if3137.praktikum2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3137.praktikum2.Hewan
import org.d3if3137.praktikum2.main.MainAdapter
import org.d3if3137.praktikum2.R
import org.d3if3137.praktikum2.databinding.FragmentHitungBinding

class HitungFragment : Fragment() { //mod4

    private lateinit var binding: FragmentHitungBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.recycleView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter()
            setHasFixedSize(true)
        }
    }
}