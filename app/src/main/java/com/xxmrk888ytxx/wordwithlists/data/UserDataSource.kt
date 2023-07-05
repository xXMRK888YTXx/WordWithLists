package com.xxmrk888ytxx.wordwithlists.data

import com.xxmrk888ytxx.wordwithlists.data.models.LocalUserModel
import kotlinx.coroutines.flow.Flow

interface UserDataSource {

    val users: Flow<List<LocalUserModel>>
}