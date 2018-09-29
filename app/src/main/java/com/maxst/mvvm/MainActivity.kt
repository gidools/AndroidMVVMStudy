package com.maxst.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maxst.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	val model = MainViewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
		activityMainBinding.model = model
		model.onCreate()
	}
}

