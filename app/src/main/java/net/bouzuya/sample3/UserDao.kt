package net.bouzuya.sample3

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun findAll(): LiveData<List<User>>

    @Insert
    suspend fun insert(user: User)

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}
