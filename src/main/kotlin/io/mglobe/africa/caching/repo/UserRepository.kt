package io.mglobe.africa.caching.repo

import io.mglobe.africa.caching.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.redis.core.RedisHash
import org.springframework.stereotype.Repository

/**
 * Created by sakawabob on 26/03/2022.
 */
@Repository
//@RedisHash
interface UserRepository: JpaRepository<User, Long>{

}