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

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.anhhn.kotlindemo.utils.DialogUtils

abstract class BaseActivity<T : ViewDataBinding>: AppCompatActivity() {

    lateinit var viewBinding: T
    lateinit var mLoadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        mLoadingDialog = DialogUtils.createLoadingDialog(this)
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showMessage(@StringRes stringResId: Int) {
        Toast.makeText(this, stringResId, Toast.LENGTH_LONG).show()
    }

    fun showLoadingDialog() {
        if (!mLoadingDialog.isShowing)
            mLoadingDialog.show()
    }

    fun dismissLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing)
            mLoadingDialog.dismiss()
    }

    abstract fun getLayoutResId(): Int
    abstract fun getFirstFragment(): Fragment?
    abstract fun getFragmentContainerId(): Int
}