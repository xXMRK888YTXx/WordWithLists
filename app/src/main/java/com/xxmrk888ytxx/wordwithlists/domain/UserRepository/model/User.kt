package com.xxmrk888ytxx.wordwithlists.domain.UserRepository.model

data class User(
    val firstName:String,
    val lastName:String,
    val age:Int,
    val isMan:Boolean,
    val avatarUrl:String?,
    val description:String
)
