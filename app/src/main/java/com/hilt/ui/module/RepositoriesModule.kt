package com.hilt.ui.module

import com.hilt.ui.repo.imglist.ImageNetworkRepository
import com.hilt.ui.repo.imglist.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
//List all API related impl
interface RepositoriesModule {
    @Binds
    fun mainRepository(mainRepositoryImpl: MainRepositoryImpl): ImageNetworkRepository
}