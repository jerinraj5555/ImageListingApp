package com.hilt.ui.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LoginModel::class],
    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract  class Database : RoomDatabase(){
    abstract fun getLogin():LoginDao
}