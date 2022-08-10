package com.example.primenumberapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primenumberapplication.data.PrimeNumberItem
import com.example.primenumberapplication.databinding.ItemPrimeNumberLayoutBinding

class PrimeNumberAdapter(
    private val primeNumberList: ArrayList<PrimeNumberItem>
): RecyclerView.Adapter<PrimeNumberAdapter.ViewHolder>()   {

    fun updatePrimeNumberList(newPrimeNumberList: List<PrimeNumberItem>){
        primeNumberList.addAll(newPrimeNumberList)
        notifyItemChanged(primeNumberList.size -1 , newPrimeNumberList.size - 1)
    }

    inner class ViewHolder(
        private val binding: ItemPrimeNumberLayoutBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(
            primeNumberItem : PrimeNumberItem
        ){
            binding.index.text = primeNumberItem.index.toString()
            binding.indexValue.text = primeNumberItem.indexValue.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrimeNumberAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPrimeNumberLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrimeNumberAdapter.ViewHolder, position: Int) {
        holder.bind(primeNumberList[position])
    }

    override fun getItemCount() = primeNumberList.size
}