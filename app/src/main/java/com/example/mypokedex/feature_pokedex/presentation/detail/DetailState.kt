package com.example.mypokedex.feature_pokedex.presentation.detail

import com.example.mypokedex.core.util.UiText
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon

data class DetailState (
    val pokemon: Pokemon = Pokemon(),
    val hasError: Boolean = false,
    val errorMessage: UiText = UiText.unknownError()
)