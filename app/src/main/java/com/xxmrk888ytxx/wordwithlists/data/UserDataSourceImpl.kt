package com.xxmrk888ytxx.wordwithlists.data

import com.github.javafaker.Faker
import com.xxmrk888ytxx.wordwithlists.ApplicationScope
import com.xxmrk888ytxx.wordwithlists.data.models.LocalUserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

class UserDataSourceImpl @Inject constructor() : UserDataSource {

    private val _users = MutableStateFlow<List<LocalUserModel>>(emptyList())

    override val users: Flow<List<LocalUserModel>> = _users.asStateFlow()

    init {
        ApplicationScope.launch() {
            val finalList = mutableListOf<LocalUserModel>()

            repeat(30) {
                val user = LocalUserModel(
                    firstName = Faker.instance().name().firstName(),
                    lastName = Faker.instance().name().lastName(),
                    age = Random(System.currentTimeMillis()).nextInt(0,99),
                    isMan = Random(System.currentTimeMillis()).nextBoolean(),
                    avatarUrl = "https://image.cnbcfm.com/api/v1/image/105773423-1551716977818rtx6p9yw.jpg?v=1551717428&w=700&h=700",
                    description = Faker.instance().demographic().demonym()
                )

                finalList.add(user)
            }

            _users.update { finalList }
        }
    }
}