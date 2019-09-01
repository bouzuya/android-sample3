package net.bouzuya.sample3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun findAll(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun findById(id: Long): List<User>

    @Insert
    suspend fun insert(user: User)

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}
