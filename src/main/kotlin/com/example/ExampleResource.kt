package com.example

import com.example.service.PokemonService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource {

    @Inject
    private lateinit var pokemonService: PokemonService


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = pokemonService.greeting("Otto")
}