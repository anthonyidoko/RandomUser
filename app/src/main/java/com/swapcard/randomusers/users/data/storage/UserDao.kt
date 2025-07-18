package com.swapcard.randomusers.users.data.storage

import androidx.room.Dao
import androidx.room.Insert
import com.swapcard.randomusers.users.data.storage.entity.UserEntity


@Dao
interface UserDao {

    @Insert()
    fun addUser(user: UserEntity)
}
