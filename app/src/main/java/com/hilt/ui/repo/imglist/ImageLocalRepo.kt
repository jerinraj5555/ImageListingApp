package com.hilt.ui.repo.imglist

import com.hilt.ui.db.ImageEntity
import kotlinx.coroutines.flow.Flow

interface ImageLocalRepo {
    suspend fun insertAll(list:List<ImageEntity>)
    fun getAllImages(): Flow<List<ImageEntity>>
}