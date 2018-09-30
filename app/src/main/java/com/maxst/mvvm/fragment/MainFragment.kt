package com.maxst.mvvm.fragment

import android.support.v4.app.Fragment
import android.support.annotation.NonNull
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.maxst.mvvm.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

	fun newInstance(param1: String, param2: String): MainFragment {
		val fragment = MainFragment()
		val args = Bundle()
		fragment.arguments = args
		return fragment
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_main, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		btnTextBinding.setOnClickListener{ clickedOn(TextBindingFragment())}
		btnButtonBinding.setOnClickListener{ clickedOn(ButtonBindingFragment())}
		btnInputValidation.setOnClickListener { clickedOn(InputValidBindingFragment())}
		btnList.setOnClickListener{ clickedOn(ListBindingFragment())}
	}

	private fun clickedOn(fragment: Fragment) {
		val tag = fragment.javaClass.toString()
		activity!!.supportFragmentManager
				.beginTransaction()
				.addToBackStack(tag)
				.replace(android.R.id.content, fragment, tag)
				.commit()
	}
}