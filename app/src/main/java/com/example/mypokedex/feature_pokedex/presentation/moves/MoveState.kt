package com.example.mypokedex.feature_pokedex.presentation.moves

import com.example.mypokedex.core.util.UiText
import com.example.mypokedex.feature_pokedex.domain.model.MoveEntry

data class MoveState (
    val moves: List<MoveEntry> = emptyList(),
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: UiText = UiText.unknownError()
)
