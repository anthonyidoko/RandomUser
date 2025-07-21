package com.swapcard.randomusers.di

import android.content.Context
import androidx.room.Room
import com.swapcard.randomusers.users.data.storage.UserDao
import com.swapcard.randomusers.users.data.storage.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return Room.databaseBuilder(
            context = context,
            UserDatabase::class.java,
            "user_database"
        ).build()
    }


    @Provides
    @Singleton
    fun provideUserData(
        userDatabase: UserDatabase
    ): UserDao {
        return userDatabase.userDao()
    }
}