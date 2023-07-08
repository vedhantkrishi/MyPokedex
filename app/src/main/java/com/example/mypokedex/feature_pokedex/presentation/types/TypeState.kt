package com.example.mypokedex.feature_pokedex.presentation.types

import com.example.mypokedex.core.util.UiText
import com.example.mypokedex.feature_pokedex.domain.model.TypeEntry

data class TypeState (
    val types: List<TypeEntry> = emptyList(),
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: UiText = UiText.unknownError()
)
