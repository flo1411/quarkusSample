package com.example.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.QueryParam


@ApplicationScoped
class PokemonService {

    fun greeting(name: String): String {
        return "hello $name"
    }

}