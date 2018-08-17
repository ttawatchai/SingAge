package com.example.n007.examplekotlin.network

import com.example.n007.examplekotlin.model.People
import io.reactivex.Observable
import retrofit2.http.GET

interface PeopleApi {
    @GET("/peoples")
    fun getPeoples(): Observable<List<People>>
}