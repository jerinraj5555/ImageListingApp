package com.hilt.ui.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageListDao {

    @Query("SELECT * FROM image ")
    fun getAllImages(): Flow<List<ImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: List<ImageEntity>)

}