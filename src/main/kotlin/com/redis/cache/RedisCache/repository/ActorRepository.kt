package com.redis.cache.RedisCache.repository

import com.redis.cache.RedisCache.Actor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : CrudRepository<Actor, String>
