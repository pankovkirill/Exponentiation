package com.example.exponentiation.mvpdetails

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView : MvpView {
    fun showResult(result: Int)
}