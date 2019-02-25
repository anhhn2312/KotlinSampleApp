package com.anhhn.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.Toast
import com.anhhn.kotlindemo.base.BaseAdapter
import com.anhhn.kotlindemo.base.BaseViewHolder
import com.anhhn.kotlindemo.databinding.ItemWeatherBinding
import com.anhhn.kotlindemo.pojo.model.WeatherModel

/**
 * Created by Andy Ha on 2/22/19.
 */
class WeatherAdapter(context: Context?) : BaseAdapter<WeatherModel, WeatherAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemWeatherBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemWeatherBinding
    ) : BaseViewHolder<WeatherModel>(binding) {
        override fun bindView(item: WeatherModel?) {
            binding.apply {
                viewModel = item
                clickListener = View.OnClickListener {
                    Toast.makeText(
                        binding.root.context,
                        adapterPosition.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                executePendingBindings()
            }
        }
    }
}