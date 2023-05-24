package org.d3if3137.praktikum2.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if3137.praktikum2.Hewan
import org.d3if3137.praktikum2.R
import org.d3if3137.praktikum2.databinding.ListItemBinding

class MainAdapter :  RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    private lateinit var myAdapter: MainAdapter
    private val data = mutableListOf<Hewan>()

    fun updateData(newData: List<Hewan>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private fun notifyDataSetChanged() {

        }

        fun bind(hewan: Hewan) = with(binding){
            namaTextView.text = hewan.nama
            latinTextView.text = hewan.namaLatin
            imageView.setImageResource(R.drawable.angsa)

            root.setOnClickListener{
                val message = root.context.getString(R.string.message, hewan.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}