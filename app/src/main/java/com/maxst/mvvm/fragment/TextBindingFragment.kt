package com.maxst.mvvm.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxst.mvvm.R
import com.maxst.mvvm.vm.TextViewModel
import android.R.attr.data
import android.databinding.DataBindingUtil
import com.maxst.mvvm.databinding.FragmentTextBindingBinding

class TextBindingFragment: Fragment() {

	val model = TextViewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val binding = FragmentTextBindingBinding.inflate(inflater, container, false)
		binding.model = model
		model.onCreate()
		return binding.root
	}
}