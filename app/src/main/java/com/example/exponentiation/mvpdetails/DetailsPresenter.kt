package com.example.exponentiation.mvpdetails

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.subjects.ReplaySubject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class DetailsPresenter : MvpPresenter<DetailsView>() {

    private val subject: ReplaySubject<Int> = ReplaySubject.create()

    private val result: Observable<Int> = getResult(subject)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showResult(0)
    }

    fun subscribe() {
        result.subscribe { viewState.showResult(it) }
    }

    private fun getResult(subject: ReplaySubject<Int>): Observable<Int> =
        subject.map {
            it * it
        }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

    fun multiply(number: Int) {
        subject.onNext(number)
    }
}