package com.redis.cache.RedisCache.controller

import com.redis.cache.RedisCache.Actor
import com.redis.cache.RedisCache.Movie
import com.redis.cache.RedisCache.model.ActorDto
import com.redis.cache.RedisCache.service.ActorServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/actors")
class ActorController (val actorServiceImpl: ActorServiceImpl){

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private fun createActor(@Validated @RequestBody actor: ActorDto): Actor = actorServiceImpl.create(actor)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private fun getActor(@PathVariable id:String):Actor = actorServiceImpl.get(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private fun updateActor(@PathVariable id:String,@Validated actor:ActorDto):Actor = actorServiceImpl.update(id,actor)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private fun getActors():List<Actor> = actorServiceImpl.getAll()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private fun deleteActor(@PathVariable id: String) = actorServiceImpl.delete(id)

    @PatchMapping("/{actorId}/link/{movieId}")
    private fun addActorToMovie(@PathVariable actorId:String,@PathVariable movieId:String):Movie = actorServiceImpl.addActorToMovie(actorId,movieId)
}
