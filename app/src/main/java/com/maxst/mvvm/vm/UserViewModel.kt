package com.maxst.mvvm.vm

import android.databinding.ObservableField

class UserViewModel(name: String, email: String) {

	val name = ObservableField<String>()
	val email = ObservableField<String>()

	init {
		this.name.set(name)
		this.email.set(email)
	}
}