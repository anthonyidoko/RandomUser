package com.swapcard.randomusers.di

import android.content.Context
import androidx.room.Room
import com.swapcard.randomusers.BuildConfig
import com.swapcard.randomusers.users.data.network.UsersApi
import com.swapcard.randomusers.users.data.repository.RandomUsersRepository
import com.swapcard.randomusers.users.data.storage.UserDao
import com.swapcard.randomusers.users.data.storage.UserDatabase
import com.swapcard.randomusers.users.data.utils.AppCoroutineDispatchProvider
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.usecase.GetUsersUseCase
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.domain.usecase.UsersManager
import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()
    private val converterFactory = json.asConverterFactory(contentType)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            client.addInterceptor(interceptor)
        }
        return client.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideDragonSearchService(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }

    @Provides
    fun provideUserRepository(
        usersApi: UsersApi,
        userDao: UserDao,
        dispatcher: CoroutineDispatchProvider
    ): UsersRepository {
        return RandomUsersRepository(
            usersApi = usersApi,
            userDao = userDao,
            dispatcher = dispatcher
        )
    }

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatchProvider = AppCoroutineDispatchProvider()

    @Provides
    fun provideUsersCombinator(
        dispatchProvider: CoroutineDispatchProvider
    ): UsersManager = UsersManager(dispatchProvider)

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

    @Provides
    fun provideGetUsersUseCase(
        repository: UsersRepository,
        dispatchProvider: CoroutineDispatchProvider,
        combinator: UsersManager
    ): GetUsersUseCase {
        return GetUsersUseCase(
            repository = repository,
            dispatchProvider = dispatchProvider,
            combinator = combinator
        )
    }

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