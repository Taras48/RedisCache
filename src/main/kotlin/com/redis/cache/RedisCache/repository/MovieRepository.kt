package com.redis.cache.RedisCache.repository

import com.redis.cache.RedisCache.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, String>
