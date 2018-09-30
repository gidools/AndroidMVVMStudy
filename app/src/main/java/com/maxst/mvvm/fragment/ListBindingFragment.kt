package com.maxst.mvvm.fragment

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import com.maxst.mvvm.R
import com.maxst.mvvm.databinding.FragmentListViewBinding
import com.maxst.mvvm.databinding.UserListItemBinding
import com.maxst.mvvm.vm.ListViewModel
import com.maxst.mvvm.vm.UserViewModel

class ListBindingFragment: Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val binding = FragmentListViewBinding.inflate(inflater, container, false)
		val model = ListViewModel()
		binding.model = model
		return binding.root
	}
}

@BindingAdapter("app:items") fun setUserList(listView: ListView, users: ObservableArrayList<UserViewModel>) {
	val adapter: UserListAdapter
	if (listView.adapter == null) {
		adapter = UserListAdapter(users)
		listView.adapter = adapter
	} else {
		adapter = listView.adapter as UserListAdapter
	}

	adapter.notifyDataSetChanged()
}

class UserListAdapter(private val users: ObservableArrayList<UserViewModel>): BaseAdapter() {

	override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
		val binding: UserListItemBinding
		val newView: View
		if (convertView == null) {
			binding = DataBindingUtil.inflate(LayoutInflater.from(parent!!.context), R.layout.user_list_item, parent, false);
			newView = binding.root
			newView.tag = binding
		} else {
			binding = convertView.tag as UserListItemBinding
			newView = convertView
		}

		binding.user = getItem(position)

		return newView
	}

	override fun getItem(position: Int): UserViewModel {
		return users[position]
	}

	override fun getItemId(position: Int): Long {
		return 0
	}

	override fun getCount(): Int {
		return users.size
	}

}