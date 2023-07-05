package com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth.models.FourthScreenModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FourthViewModel @Inject constructor(

)  : ViewModel() {

    private val _items = MutableStateFlow(emptyList<FourthScreenModel>())

    val items = _items.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            val finalList = mutableListOf<FourthScreenModel>()
            val number = (1..32).map { it }.chunked(4)

            var isReversed = false

            number.forEach { chunk ->
                if(chunk.size == 4) {
                    finalList.add(
                        FourthScreenModel.DefaultItem(
                            bigItem = chunk[0],
                            littleItems = chunk[1] to chunk[2],
                            isReversed = isReversed
                        )
                    )

                    isReversed = !isReversed
                    finalList.add(FourthScreenModel.SingleItem(chunk[3]))
                } else {
                    chunk.forEach {
                        finalList.add(FourthScreenModel.SingleItem(it))
                    }
                }
            }

            _items.update { finalList }


        }
    }
}