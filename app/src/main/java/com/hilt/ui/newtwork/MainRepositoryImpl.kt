package com.hilt.ui.newtwork

import com.hilt.ui.repo.imglist.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService): MainRepository {
    override suspend fun getAllImages() = apiService.getAllImages()
}