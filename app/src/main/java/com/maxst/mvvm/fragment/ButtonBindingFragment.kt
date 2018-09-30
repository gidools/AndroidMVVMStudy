package com.maxst.mvvm.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxst.mvvm.databinding.FragmentButtonBindingBinding
import com.maxst.mvvm.vm.ButtonViewModel

class ButtonBindingFragment: Fragment() {

	val model = ButtonViewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val binding = FragmentButtonBindingBinding.inflate(inflater, container, false)
		binding.model = model
		model.onCreate()
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
}