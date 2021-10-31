package com.hilt.ui.repo.imglist
import com.hilt.ui.db.ImageEntity
import com.hilt.ui.newtwork.model.ImageModel
import retrofit2.Response

interface ImageNetworkRepository {
    suspend fun getAllImages() : Response<List<ImageEntity>>
}