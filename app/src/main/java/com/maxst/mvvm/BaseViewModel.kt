package com.maxst.mvvm

interface BaseViewModel {

	fun onCreate()
	fun onResume()
	fun onPause()
	fun onDestroy()
}