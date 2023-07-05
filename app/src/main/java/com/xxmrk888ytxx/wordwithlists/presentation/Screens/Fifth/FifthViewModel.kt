package com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fifth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.UserRepository
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fifth.models.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FifthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {


    private val isLoadingState = MutableStateFlow(true)
    private val isPullToRefreshInProcess = MutableStateFlow(false)
    private val isEmptyList = MutableStateFlow(false)


    val screenState = combine(
        isLoadingState,
        isPullToRefreshInProcess,
        isEmptyList,
        userRepository.users
    ) { isLoading,isPullToRefreshInProcess,isEmptyList,userList ->
        ScreenState(isLoading,isPullToRefreshInProcess,isEmptyList,userList)
    }

    fun toEmptyState() {
        isEmptyList.update { true }
    }

    fun pullRefresh() {
        viewModelScope.launch {
            isPullToRefreshInProcess.update { true }
            delay(3000)

            isEmptyList.update { false }
            isPullToRefreshInProcess.update { false }
        }
    }


    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(6000)
            isLoadingState.update { false }
        }
    }

}