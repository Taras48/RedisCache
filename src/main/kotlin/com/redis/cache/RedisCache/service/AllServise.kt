package com.redis.cache.RedisCache.service

interface AllServise<T, D> {
    fun get(id: String): T
    fun getAll(): List<T>
    fun update(id: String, dto: D): T
    fun update(obg: T): T
    fun create(obg: D): T
    fun delete(id: String)
}
