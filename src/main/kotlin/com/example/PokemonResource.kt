package com.example

import com.example.service.CallExternalApiService
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder
import jakarta.ws.rs.BadRequestException
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.net.URI


@Path("/pokemonList")
class PokemonResource() {

    final var callExternalApiService: CallExternalApiService? = null

    init {
        callExternalApiService = QuarkusRestClientBuilder.newBuilder()
            .baseUri(URI.create("https://pokeapi.co/api"))
            .build(CallExternalApiService::class.java)
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getPokeMons() = run {
        val pokemonResponse = callExternalApiService?.getPokemon()
        if (pokemonResponse?.count == 0) {
            //400
            throw BadRequestException()
        }
        pokemonResponse

    }
}