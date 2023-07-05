package com.xxmrk888ytxx.wordwithlists.Di

import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.UserRepository
import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ) : UserRepository
}