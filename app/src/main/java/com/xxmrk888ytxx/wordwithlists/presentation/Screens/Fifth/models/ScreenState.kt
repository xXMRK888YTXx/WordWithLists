package com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fifth.models

import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.model.User

data class ScreenState(
    val isLoading:Boolean,
    val isPullToRefreshInProcess:Boolean,
    val isEmptyList:Boolean,
    val userList:List<User>
)
