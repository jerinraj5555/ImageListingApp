package com.hilt.ui.module

import com.hilt.ui.newtwork.MainRepositoryImpl
import com.hilt.ui.repo.imglist.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
//List all API related impl
interface RepositoriesModule {
    @Binds
    fun mainRepository(mainRepositoryImpl: MainRepositoryImpl) : MainRepository
}