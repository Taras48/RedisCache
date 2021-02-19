package com.redis.cache.RedisCache.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.PastOrPresent

data class MovieDto(
    @get:NotBlank val name: String?,
    @get:NotBlank val gender: String?,
    @get:Min(value = 1900) @PastOrPresent val year: Int
)

data class ActorDto(
    @get:NotBlank val firstName: String,
            @get:NotBlank val lastName: String,
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    @field:JsonDeserialize(using = LocalDateDeserializer::class)
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @get:Past val birthDate: LocalDate
)
