package com.siddhesh.obvioustest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.siddhesh.obvioustest.R
import com.siddhesh.obvioustest.databinding.ItemImageGridBinding
import com.siddhesh.obvioustest.viewmodels.ImageItemViewModel

class GridAdapter(private var list: ArrayList<ImageItemViewModel>) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemImageGridBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_image_grid, parent, false
        )
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ItemImageGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageItemViewModel) {
            binding.vm = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setData(items: ArrayList<ImageItemViewModel>) {
        list = items
        notifyDataSetChanged()
    }
}