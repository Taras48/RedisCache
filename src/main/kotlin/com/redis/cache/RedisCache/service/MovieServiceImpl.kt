package com.redis.cache.RedisCache.service

import com.redis.cache.RedisCache.Movie
import com.redis.cache.RedisCache.exeptions.MovieNotFoundException
import com.redis.cache.RedisCache.model.MovieDto
import com.redis.cache.RedisCache.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(val movieRepository: MovieRepository) : AllServise<Movie, MovieDto> {
    override fun get(id: String): Movie = movieRepository.findById(id)
        .orElseThrow { MovieNotFoundException("not movie with id - $id") }

    override fun getAll(): List<Movie> = movieRepository.findAll().toList()

    override fun update(id: String, dto: MovieDto): Movie {
        val movie: Movie = movieRepository.findById(id)
            .orElseThrow { MovieNotFoundException("not movie with id - $id") }
        val upMovies = movie.copy(name = dto.name.orEmpty(), gender = dto.gender.orEmpty(), year = dto.year)
        upMovies.id = movie.id
        return movieRepository.save(upMovies)
    }

    override fun update(obg: Movie): Movie = movieRepository.save(obg)

    override fun create(obg: MovieDto): Movie =
        movieRepository.save(Movie(name = obg.name.orEmpty(), gender = obg.gender.orEmpty(), year = obg.year))

    override fun delete(id: String) = movieRepository.delete(get(id))
}
