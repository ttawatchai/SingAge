package com.example.n007.examplekotlin.ui.PeopleList

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.n007.examplekotlin.base.BaseViewModel
import com.example.n007.examplekotlin.network.PeopleApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PeopleListViewModel: BaseViewModel(){
    @Inject
    lateinit var peopleApi: PeopleApi
    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPeople() }



    init{
        loadPeople()
    }

    private fun loadPeople(){
        subscription = peopleApi.getPeoples()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { onRetrievePostListSuccess() },
                        { onRetrievePostListError() }
                )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null

    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.VISIBLE

    }

    private fun onRetrievePostListSuccess(){

    }

    private fun onRetrievePostListError(){

    }
}