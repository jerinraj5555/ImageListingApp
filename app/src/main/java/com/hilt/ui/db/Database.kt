package com.hilt.ui.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hilt.ui.Converters

@Database(
    entities = [LoginModel::class,ImageEntity::class],
    version = 2,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract  class Database : RoomDatabase(){
    abstract fun getLogin():LoginDao
    abstract fun getImages():ImageListDao
}