package com.xxmrk888ytxx.wordwithlists.Di

import com.xxmrk888ytxx.wordwithlists.data.UserDataSource
import com.xxmrk888ytxx.wordwithlists.data.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindUserDataSource(
        UserDataSourceImpl: UserDataSourceImpl
    ) : UserDataSource
}