package com.redis.cache.RedisCache.service

import com.redis.cache.RedisCache.Actor
import com.redis.cache.RedisCache.Movie
import com.redis.cache.RedisCache.exeptions.ActorNotFoundException
import com.redis.cache.RedisCache.model.ActorDto
import com.redis.cache.RedisCache.repository.ActorRepository
import org.springframework.stereotype.Service

@Service
class ActorServiceImpl(val actorRepository: ActorRepository, val movieService: MovieServiceImpl) :
    AllServise<Actor, ActorDto> {
    override fun get(id: String): Actor =
        actorRepository.findById(id).orElseThrow { ActorNotFoundException("Actor with id - $id not found") }

    override fun getAll(): List<Actor> = actorRepository.findAll().toList()

    override fun update(id: String, dto: ActorDto): Actor {
        val actor = actorRepository.findById(id).orElseThrow { ActorNotFoundException("Actor with id - $id not found") }
        val upActor = actor.copy(firstName = actor.firstName, lastName = actor.lastName, birthDate = actor.birthDate)
        upActor.id = actor.id
        return actorRepository.save(upActor)
    }

    override fun update(obg: Actor): Actor = actorRepository.save(obg)

    override fun create(obg: ActorDto): Actor =
        actorRepository.save(Actor(firstName = obg.firstName, lastName = obg.lastName, birthDate = obg.birthDate))

    override fun delete(id: String) = actorRepository.delete(get(id))

    fun addActorToMovie(actorId: String, moviesId: String): Movie {
        val movie = movieService.get(moviesId)
        val actor = get(actorId)
        (movie.actors as ArrayList).add(actor)
        return movieService.update(movie)
    }
}
