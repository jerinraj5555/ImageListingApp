package com.hilt.ui.module

import android.app.Application
import androidx.room.Room
import com.hilt.ui.db.Database
import com.hilt.ui.db.LoginDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): Database {
        return Room.databaseBuilder(app, Database::class.java, "image_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginDao(db: Database): LoginDao {
        return db.getLogin()
    }


}