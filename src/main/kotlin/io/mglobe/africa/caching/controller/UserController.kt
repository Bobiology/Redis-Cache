package io.mglobe.africa.caching.controller

import io.mglobe.africa.caching.model.User
import io.mglobe.africa.caching.service.UserService
import io.mglobe.africa.caching.service.impl.UserServiceImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

/**
 * Created by sakawabob on 26/03/2022.
 */
@RestController
@RequestMapping("user")
open class UserController {
    var log: Logger = LoggerFactory.getLogger(UserController::class.java)
    @Autowired
    lateinit var userService: UserService

    final var userSvc: UserService? = null
    @JvmName("getUserService1")
    fun getUserService(): UserService? {
        userSvc = userService
        return userService
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addUser(@Valid @RequestBody user: User?): User? {
        log.info("Creating user with name ${user?.name}")

        var newUser:User? = User()
        newUser = getUserService()?.addUser(user)!!
        return newUser
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun editUser(@RequestBody user: User): User? {
        log.info("Editing user with Id ${user.id}")
        return getUserService()?.editUser(user)
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findUser(@PathVariable userId: Long): User? {
        log.info("Getting user with Id $userId")
        return getUserService()?.findUser(userId)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listAll(): MutableList<User>? {
        log.info("list all users")
        return getUserService()?.listAll()
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{userId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun removeUser(@PathVariable userId: Long){
        log.info("Deleting user with Id $userId")
        getUserService()?.deleteUser(userId)
    }


}