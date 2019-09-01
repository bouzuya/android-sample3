package net.bouzuya.sample3

class UserRepository(private val _userDao: UserDao) {
    suspend fun findAll(): List<User> = _userDao.findAll()

    suspend fun findById(id: Long): User? = _userDao.findById(id).firstOrNull()

    suspend fun insert(user: User): Unit = _userDao.insert(user)

    suspend fun deleteAll(): Unit = _userDao.deleteAll()
}
