package com.maxst.mvvm

import android.databinding.ObservableField
import android.view.View

class MainViewModel : BaseViewModel {

	public val helloText = ObservableField<String>()

	override fun onCreate() {
		helloText.set("Hello Jack!")
	}

	override fun onResume() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onPause() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onDestroy() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	public fun showCurrentTime() {
		helloText.set(System.currentTimeMillis().toString())
	}

	public val currentTime2ClickListener = View.OnClickListener {
		showCurrentTime()
	}

}