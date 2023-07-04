package com.example.mypokedex.feature_pokedex.data.remote

import com.example.mypokedex.feature_pokedex.data.remote.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String
    ) : PokemonResponse


}