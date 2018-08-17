package com.example.n007.examplekotlin.base

import android.arch.lifecycle.ViewModel
import com.example.n007.examplekotlin.injection.component.ViewModelInjector
import com.example.n007.examplekotlin.injection.DaggerViewModelInjector
import com.example.n007.examplekotlin.injection.module.NetworkModule
import com.example.n007.examplekotlin.ui.PeopleList.PeopleListViewModel



abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PeopleListViewModel -> injector.inject(this)
        }
    }
}
