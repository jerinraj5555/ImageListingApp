package com.hilt.ui.repo.imglist

import com.hilt.ui.db.ImageEntity
import com.hilt.ui.db.ImageListDao
import javax.inject.Inject

class ImageLocalRepoImpl @Inject constructor(private val dao: ImageListDao) : ImageLocalRepo {
    override suspend fun insertAll(list: List<ImageEntity>) {
        dao.insert(list)
    }

    override fun getAllImages() = dao.getAllImages()
}