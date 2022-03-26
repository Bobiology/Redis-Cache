package io.mglobe.africa.caching.service

import io.mglobe.africa.caching.model.User
import java.util.*

/**
 * Created by sakawabob on 26/03/2022.
 */
interface UserService {
    fun addUser(user: User?): User?
    fun editUser(user:User?):User?
    fun findUser(userId:Long?): User?
    fun deleteUser(userId: Long)
    fun listAll(): MutableList<User>?
}