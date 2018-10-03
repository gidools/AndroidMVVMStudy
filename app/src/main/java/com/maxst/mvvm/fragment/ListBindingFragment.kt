package com.maxst.mvvm.fragment

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxst.mvvm.R
import com.maxst.mvvm.databinding.FragmentListViewBinding
import com.maxst.mvvm.databinding.UserListItemBinding
import com.maxst.mvvm.vm.ListViewModel
import com.maxst.mvvm.vm.UserViewModel

class ListBindingFragment: Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val binding = FragmentListViewBinding.inflate(inflater, container, false)
		binding.model = ListViewModel()
		return binding.root
	}
}

@BindingAdapter("app:items") fun setUserList(recyclerView: RecyclerView, users: ObservableArrayList<UserViewModel>) {
	val adapter: UserListAdapter
	if (recyclerView.adapter == null) {
		adapter = UserListAdapter(users)
		recyclerView.adapter = adapter
	} else {
		adapter = recyclerView.adapter as UserListAdapter
	}

	adapter.notifyItemInserted(users.size - 1)
}

class BindingViewHolder<T : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
	val binding: T = DataBindingUtil.bind<ViewDataBinding>(view) as T
}

class UserListAdapter(private val users: ObservableArrayList<UserViewModel>) : RecyclerView.Adapter<BindingViewHolder<UserListItemBinding>>() {

	override fun onCreateViewHolder(parent: ViewGroup, position: Int): BindingViewHolder<UserListItemBinding> {
		val inflater = LayoutInflater.from(parent.context)
		return BindingViewHolder<UserListItemBinding>(inflater.inflate(R.layout.user_list_item, parent, false))
	}

	override fun getItemCount(): Int {
		return users.size
	}

	override fun onBindViewHolder(holder: BindingViewHolder<UserListItemBinding>, position: Int) {
		holder.binding.user = users[position]
	}

}