package com.xxmrk888ytxx.wordwithlists.domain.UserRepository

import com.xxmrk888ytxx.wordwithlists.data.UserDataSource
import com.xxmrk888ytxx.wordwithlists.data.models.LocalUserModel
import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {


    override val users: Flow<List<User>> = userDataSource.users.map { list ->
        list.map { it.toUser() }
    }

    private fun LocalUserModel.toUser() : User {
        return User(firstName, lastName, age, isMan, avatarUrl, description)
    }
}