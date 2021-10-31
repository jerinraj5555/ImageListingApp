package com.hilt.ui.repo.imglist

import com.hilt.ui.db.ImageEntity
import com.hilt.ui.newtwork.ApiService
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ImageNetworkRepository {
    override suspend fun getAllImages(): Response<List<ImageEntity>> = apiService.getAllImages()
}