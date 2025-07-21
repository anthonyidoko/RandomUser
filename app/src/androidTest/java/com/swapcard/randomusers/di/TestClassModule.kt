package com.swapcard.randomusers.di

import android.content.Context
import androidx.room.Room
import com.swapcard.randomusers.data.TestUserRepository
import com.swapcard.randomusers.users.data.storage.UserDao
import com.swapcard.randomusers.users.data.storage.UserDatabase
import com.swapcard.randomusers.users.data.utils.AppCoroutineDispatchProvider
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.domain.usecase.UsersManager
import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class, DatabaseModule::class]
)
@Module
object TestClassModule {

    @Provides
    @Singleton
    fun provideInMemoryDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
    }

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideUsersManager(
        dispatchProvider: CoroutineDispatchProvider
    ): UsersManager = UsersManager(dispatchProvider)

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatchProvider = AppCoroutineDispatchProvider()


    @Provides
    fun provideUserRepository(
        userDao: UserDao
    ): UsersRepository{
        return TestUserRepository(userDao)
    }

    @Provides
    fun provideUserBookMarkUseCase(
        repository: UsersRepository,
        dispatchProvider: CoroutineDispatchProvider
    ): UserBookMarkUseCase {
        return UserBookMarkUseCase(
            repository = repository,
            dispatchProvider = dispatchProvider
        )
    }
}