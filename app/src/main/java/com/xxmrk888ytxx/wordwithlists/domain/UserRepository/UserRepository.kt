package com.xxmrk888ytxx.wordwithlists.domain.UserRepository

import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val users: Flow<List<User>>
}