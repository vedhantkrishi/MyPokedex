package com.example.mypokedex.feature_pokedex.presentation.moves

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.core.util.Constants.CURRENT_OFFSET
import com.example.mypokedex.core.util.Resource
import com.example.mypokedex.core.util.UiText
import com.example.mypokedex.feature_pokedex.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoveViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var currentPageSize = 10

    var state by mutableStateOf(MoveState())
        private set

    init {
        getMoves()
    }

    fun getMoves() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            when (val result = repository.getMoves(currentPageSize, CURRENT_OFFSET)) {
                is Resource.Success -> {
                    state = state.copy(
                        moves = result.data!!,
                        isLoading = false,
                        hasError = false
                    )
                    currentPageSize += 15
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        hasError = true,
                        errorMessage = result.uiText ?: UiText.unknownError()
                    )
                }
            }
        }
    }
}
