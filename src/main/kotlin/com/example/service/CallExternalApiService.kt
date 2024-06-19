package com.example.service

import com.example.model.PokemonResponse
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/v2")
@RegisterRestClient
interface CallExternalApiService {
    @GET
    @Path("/pokemon")
    fun getPokemon(): PokemonResponse
}