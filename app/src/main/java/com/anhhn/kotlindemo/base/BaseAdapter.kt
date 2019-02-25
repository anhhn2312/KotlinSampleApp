package com.anhhn.kotlindemo.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

/**
 * Created by dong on 10/5/17.
 */

abstract class BaseAdapter<E, V : BaseViewHolder<E>>(protected val context: Context?) : RecyclerView.Adapter<V>() {
    var mItems: MutableList<E>

    val items: List<E>
        get() = mItems

    init {
        mItems = ArrayList()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun addItems(items: MutableList<E>) {
        val previousSize = mItems.size
        mItems = items
        notifyItemRangeInserted(previousSize, items.size)
    }

    fun refreshList(items: List<E>) {
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        mItems.clear()
        notifyDataSetChanged()
    }

    fun getItem(position: Int): E {
        return mItems[position]
    }
}