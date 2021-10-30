package com.hilt.ui.repo.imglist
import com.hilt.ui.newtwork.model.ImageModel
import retrofit2.Response

interface MainRepository {
    suspend fun getAllImages() : Response<List<ImageModel>>
}