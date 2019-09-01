package net.bouzuya.sample3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var _database: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return _database ?: synchronized(this) {
                _database ?: {
                    val db = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"
                    ).build()
                    _database = db
                    db
                }()
            }
        }
    }
}
