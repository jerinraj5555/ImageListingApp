package com.hilt.ui.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(login:LoginModel)
    @Query("SELECT * FROM login where email= :email ")
    fun getLoginDetails(email:String): Flow<LoginModel>
}