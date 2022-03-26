package io.mglobe.africa.caching.service.impl

import io.mglobe.africa.caching.model.User
import io.mglobe.africa.caching.repo.UserRepository
import io.mglobe.africa.caching.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * Created by sakawabob on 26/03/2022.
 */
@Service
open class UserServiceImpl:UserService {
    var log:Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)
    @Autowired
    lateinit var userRepo: UserRepository

    override fun addUser(user: User?): User? {
       log.info("Create Method")
        return userRepo.save(user)
    }

    @CachePut(value = ["users"], key ="#userId" )
    override fun editUser(user: User?): User? {
        log.info("update user of user id ${user?.id}")
        val existingRecord: User? = userRepo.findById(user?.id!!)?.orElseThrow{Exception("User Not Found")}
        var newRecord: User? = null
        if(!existingRecord?.equals(null)!!){
            existingRecord.name = user.name
            existingRecord.followers = user.followers
            newRecord = userRepo.save(existingRecord)
        }
        return newRecord!!
    }

    @Cacheable(value = ["users"], key = "#userId", unless = "#result.followers < 12000")
    override fun findUser(userId: Long?): User? {
        log.info("find user by id $userId")
        var userRecord : User = userRepo.findById(userId).orElseThrow { Exception("User Not Found") }
        log.info("Fetching from db")
        return userRecord
    }
    @CacheEvict(value = ["users"], key = "#userId")
    override fun deleteUser(userId: Long) {
        log.info("delete user by id $userId")
        var user: User = userRepo.findById(userId).orElseThrow { Exception("User Not Found") }
        userRepo.delete(user)
    }
    @Cacheable(value = ["users"])
    override fun listAll(): MutableList<User>? {
        log.info("listAll users")
        return userRepo.findAll()
    }
}
