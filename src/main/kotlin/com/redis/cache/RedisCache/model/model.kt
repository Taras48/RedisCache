package com.redis.cache.RedisCache

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Reference
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.time.LocalDate

@RedisHash("Movies")
data class Movie(
    @Indexed val name: String,
    val gender: String,
    val year: Int
) {
    @get:Id
    var id: String? = null
    @Indexed
    @get:Reference
    var actors: List<Actor> = listOf()
}

@RedisHash("Actors")
data class Actor(
    @Indexed val firstName: String,
    val lastName: String,
    val birthDate: LocalDate
) {
    @get:Id
    var id: String? = null
}
