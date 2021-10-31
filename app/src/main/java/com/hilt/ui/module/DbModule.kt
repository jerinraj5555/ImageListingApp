package com.hilt.ui.module


import com.hilt.ui.repo.imglist.ImageLocalRepo
import com.hilt.ui.repo.imglist.ImageLocalRepoImpl
import com.hilt.ui.repo.login.LoginRepo
import com.hilt.ui.repo.login.LoginRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
//List db related impl
interface DbModule {
    @Binds
    fun provideLocalDb(localRepoImpl: LoginRepoImpl): LoginRepo
    @Binds
    fun provideImgLocalDb(imgRepoImpl: ImageLocalRepoImpl): ImageLocalRepo

}