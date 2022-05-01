package com.proelbtn.sampleapp001.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proelbtn.sampleapp001.R
import com.proelbtn.sampleapp001.data.Store

class StoreAdapter(private val stores: List<Store>) : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.store_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val store = stores[position]
        viewHolder.name.text = store.title
    }

    override fun getItemCount(): Int = stores.size
}
