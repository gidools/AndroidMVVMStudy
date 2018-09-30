package com.maxst.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maxst.mvvm.fragment.MainFragment

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
					.replace(android.R.id.content, MainFragment(), this.toString())
					.commit()
		}
	}
}

