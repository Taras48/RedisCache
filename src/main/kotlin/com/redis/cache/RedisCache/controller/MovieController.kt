package com.redis.cache.RedisCache.controller

import com.redis.cache.RedisCache.Movie
import com.redis.cache.RedisCache.model.MovieDto
import com.redis.cache.RedisCache.service.MovieServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/movies")
class MovieController(val movieServiceImpl: MovieServiceImpl) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private fun createMovie(@Valid movie: MovieDto): Movie = movieServiceImpl.create(movie)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private fun getMovieById(@PathVariable id: String): Movie = movieServiceImpl.get(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private fun updateMovie(@PathVariable id: String, @Validated movie: MovieDto): Movie =
        movieServiceImpl.update(id, movie)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private fun getMovies(): List<Movie> = movieServiceImpl.getAll()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private fun deleteMovie(id: String) = movieServiceImpl.delete(id)
}
