package com.maxst.mvvm.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxst.mvvm.databinding.FragmentInputValidationBinding
import com.maxst.mvvm.vm.InputViewModel

class InputValidBindingFragment: Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val binding = FragmentInputValidationBinding.inflate(inflater, container, false)
		val model = InputViewModel()
		binding.model = model
		model.onCreate()
		return binding.root
	}
}