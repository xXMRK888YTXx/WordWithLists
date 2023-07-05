package com.xxmrk888ytxx.wordwithlists.presentation.Screens.First

import androidx.lifecycle.ViewModel
import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelWithUsers @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {


    val users = userRepository.users
}