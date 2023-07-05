package com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth.models

sealed class FourthScreenModel() {

    data class DefaultItem(
        val bigItem:Int,
        val littleItems:Pair<Int,Int>,
        val isReversed:Boolean
    ) : FourthScreenModel()

    data class SingleItem(val item:Int) : FourthScreenModel()
}
