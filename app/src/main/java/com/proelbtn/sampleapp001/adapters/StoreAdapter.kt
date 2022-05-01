package com.proelbtn.sampleapp001.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proelbtn.sampleapp001.data.Store
import com.proelbtn.sampleapp001.databinding.StoreItemBinding

class StoreAdapter(private val stores: List<Store>) : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    class ViewHolder(val binding: StoreItemBinding) : RecyclerView.ViewHolder(binding.root);

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = StoreItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val store = stores[position]
        viewHolder.binding.storeName = store.title
    }

    override fun getItemCount(): Int = stores.size
}
