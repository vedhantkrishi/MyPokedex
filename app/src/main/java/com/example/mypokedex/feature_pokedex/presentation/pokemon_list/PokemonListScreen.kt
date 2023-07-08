package com.example.mypokedex.feature_pokedex.presentation.pokemon_list

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypokedex.R
import com.example.mypokedex.core.components.ListAnimation
import com.example.mypokedex.core.components.PokemonItem
import com.example.mypokedex.core.components.TopBar
import com.example.mypokedex.core.presentation.StandardLoadingErrorScreen
import com.example.mypokedex.core.util.Screen
import com.example.mypokedex.core.util.asString
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PokemonListScreen(
    navController: NavController,
    context: Context,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            onClickIcon1 = navController::navigateUp,
            title = stringResource(R.string.pokedex)
        )
        ListAnimation(
            items = state.pokemons,
            isLoading = state.isLoading
        ) { index, pokemon ->
            val size = state.pokemons.size
            if (index >= size - 6 && !state.isLoading) {
                viewModel.getPokemons()
            }
            PokemonItem(
                pokemonInfo = pokemon,
                onClick = { navController.navigate(Screen.Detail.navArgs(pokemon.name)) }
            )
        }
    }
    StandardLoadingErrorScreen(
        hasError = state.hasError,
        errorMessage = state.errorMessage.asString(context),
        isLoading = state.isLoading,
        items = state.pokemons
    )
}