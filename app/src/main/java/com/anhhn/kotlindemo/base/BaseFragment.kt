/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.anhhn.kotlindemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by Andy Ha on 2/11/19.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<T:ViewDataBinding> : Fragment() {

    lateinit var viewBinding:T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return viewBinding.root
    }

    fun showLoadingDialog() {
        if (getBaseActivity() != null) {
            getBaseActivity().showLoadingDialog()
            return
        }
    }

    fun dismissLoadingDialog() {
        if (getBaseActivity() != null) {
            getBaseActivity().dismissLoadingDialog()
            return
        }
    }

    fun showMessage(bfMessage: String?) {
        if (activity != null && bfMessage != null)
            Toast.makeText(activity, bfMessage, Toast.LENGTH_LONG).show()
    }

    fun showMessage(@StringRes bfMessageResId: Int) {
        if (activity != null)
            Toast.makeText(activity, getString(bfMessageResId), Toast.LENGTH_LONG).show()
    }

    abstract fun getLayoutResId(): Int

    protected fun getBaseActivity(): BaseActivity<ViewDataBinding> = activity as BaseActivity<ViewDataBinding>
}