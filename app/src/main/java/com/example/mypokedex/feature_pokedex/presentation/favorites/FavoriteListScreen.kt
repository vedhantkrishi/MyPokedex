package com.example.mypokedex.feature_pokedex.presentation.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.mypokedex.R
import com.example.mypokedex.core.components.PokemonItem
import com.example.mypokedex.core.components.TopBar
import com.example.mypokedex.core.presentation.StandardLoadingErrorScreen
import com.example.mypokedex.core.util.Screen

@ExperimentalMaterialApi
@Composable
fun FavoritesListScreen(
    navController: NavController,
    viewModel: FavoritesListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = stringResource(R.string.favorites),
            onClickIcon1 = navController::navigateUp,
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.pokemonsFav) { pokemon ->
                PokemonItem(
                    pokemonInfo = pokemon,
                    onClick = {
                        navController.navigate(Screen.Detail.navArgs(pokemon.name))
                    }
                )
            }
        }
    }
    StandardLoadingErrorScreen(
        hasError = state.pokemonsFav.isEmpty(),
        errorMessage = stringResource(R.string.there_are_no_saved_items)
    )}