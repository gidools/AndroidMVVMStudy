package com.maxst.mvvm.vm

interface BaseViewModel {

	fun onCreate()
	fun onResume()
	fun onPause()
	fun onDestroy()
}