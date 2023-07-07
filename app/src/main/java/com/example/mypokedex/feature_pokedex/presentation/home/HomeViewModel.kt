package com.example.mypokedex.feature_pokedex.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.core.util.Resource
import com.example.mypokedex.core.util.UiText
import com.example.mypokedex.core.util.asString
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon
import com.example.mypokedex.feature_pokedex.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private var jobPokemon: Job? = null

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.GetSearchPokemon -> if (event.query.isNotEmpty()) {
                state = state.copy(
                    query = event.query,
                    isLoading = true
                )
                jobPokemon?.cancel()
                jobPokemon = viewModelScope.launch {
                    delay(300)
                    val result = repository.getPokemon(event.query.lowercase())
                    state = when(result) {
                        is Resource.Success -> state.copy(
                            pokemon = result.data!!,
                            isVisiblePokemon = true,
                            isLoading = false,
                            hasError = false
                        )
                        is Resource.Error -> state.copy(
                            isVisiblePokemon = false,
                            isLoading = false,
                            hasError = true,
                            errorMessage = result.uiText ?: UiText.unknownError()
                        )
                    }
                }
            }
            is HomeEvent.ClearSearchText -> state = state.copy(
                pokemon = Pokemon(),
                query = "",
                isVisiblePokemon = false,
                isLoading = false,
                hasError = false
            )
        }
    }
}