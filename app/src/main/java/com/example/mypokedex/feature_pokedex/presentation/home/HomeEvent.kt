package com.example.mypokedex.feature_pokedex.presentation.home

sealed class HomeEvent {
    data class GetSearchPokemon(val query: String) : HomeEvent()
    object ClearSearchText : HomeEvent()
}
