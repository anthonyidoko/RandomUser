package com.swapcard.randomusers.users.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.swapcard.randomusers.users.data.storage.entity.UserEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE userId = :id LIMIT 1")
    fun getUserBYID(id: String): UserEntity?

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<UserEntity>

    @Delete
    suspend fun deleteUser(user: UserEntity)
}
