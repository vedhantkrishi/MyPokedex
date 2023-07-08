package com.example.mypokedex.feature_pokedex.presentation.favorites

import com.example.mypokedex.feature_pokedex.domain.model.Pokemon

data class FavoriteListState (
    val pokemonsFav: List<Pokemon> = emptyList()
)
