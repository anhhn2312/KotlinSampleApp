package com.anhhn.kotlindemo.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by dong on 10/5/17.
 */

abstract class BaseViewHolder<E>(viewBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    abstract fun bindView(item: E?)
}
