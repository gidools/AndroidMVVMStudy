package com.maxst.mvvm.vm

import android.databinding.ObservableArrayList
import java.util.*

class ListViewModel: BaseViewModel {

	val users =  ObservableArrayList<UserViewModel>()

	override fun onCreate() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

	fun newUser() {
		users.add(UserViewModel("name " + Random().nextInt(), "email " + Random().nextInt()))
	}
}