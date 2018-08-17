package com.example.n007.examplekotlin.injection.component

import com.example.n007.examplekotlin.injection.module.NetworkModule
import com.example.n007.examplekotlin.ui.PeopleList.PeopleListViewModel
import dagger.Component

interface ViewModelInjector {

    fun inject(peopleListViewModel: PeopleListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
