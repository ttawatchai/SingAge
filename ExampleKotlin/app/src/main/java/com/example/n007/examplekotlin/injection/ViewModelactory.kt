package com.example.n007.examplekotlin.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.example.n007.examplekotlin.ui.PeopleList.PeopleListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(PeopleListViewModel::class.java)) {
//            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
//            @Suppress("UNCHECKED_CAST")
//            return PostListViewModel(db.postDao()) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")

    }
}