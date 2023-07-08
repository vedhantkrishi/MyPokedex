package com.example.mypokedex.feature_pokedex.presentation.pokemon_list

import com.example.mypokedex.core.util.UiText
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon

data class PokemonListState (
    val pokemons: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: UiText = UiText.unknownError()
)
