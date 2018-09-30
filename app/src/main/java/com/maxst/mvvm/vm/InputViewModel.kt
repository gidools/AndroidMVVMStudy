package com.maxst.mvvm.vm

import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.text.TextUtils
import android.util.Patterns
import android.widget.RatingBar

class InputViewModel: BaseViewModel {

	val name = ObservableField<String>()
	val email = ObservableField<String>()
	val score = ObservableInt()
	val isValid = ObservableBoolean()

	override fun onCreate() {
		score.set(0)
		isValid.set(false)

		name.addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
			override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
				validation()
			}
		})

		email.addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
			override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
				validation()
			}
		})
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

	private fun validation() {
		val isNameValid = !TextUtils.isEmpty(name.get())
		val isEmailVarargs = !TextUtils.isEmpty(email.get()) && Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()

		isValid.set(isNameValid && isEmailVarargs && score.get() > 0)
	}

	public val ratingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
		score.set(rating.toInt())
		validation()
	}
}