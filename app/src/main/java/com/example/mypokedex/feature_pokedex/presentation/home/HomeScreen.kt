package com.example.mypokedex.feature_pokedex.presentation.home

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController
import com.example.mypokedex.R
import com.example.mypokedex.core.components.PokemonItem
import com.example.mypokedex.core.components.ShowContentAnimation
import com.example.mypokedex.core.presentation.StandardLoadingErrorScreen
import com.example.mypokedex.core.util.Screen
import com.example.mypokedex.core.util.asString
import com.example.mypokedex.feature_pokedex.presentation.home.HomeViewModel
import com.example.mypokedex.feature_pokedex.presentation.home.components.SearchBar
import com.example.mypokedex.feature_pokedex.util.parseTypeToColor
import com.example.mypokedex.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    context: Context,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.medium),
    verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.what_are_you_looking_for),
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 28.dp)
        )
        SearchBar(
            text = state.query,
            hint = stringResource(R.string.search_pokemon),
            onSearch = { viewModel.onEvent(HomeEvent.GetSearchPokemon(it)) },
            clearText = { viewModel.onEvent(HomeEvent.ClearSearchText) }
        )

        if (state.query.isNotBlank()) {
            ShowContentAnimation(isVisible = state.isVisiblePokemon) {
                PokemonItem(
                    pokemonInfo = state.pokemon,
                    boxColor = if (state.pokemon.name.isNotBlank()) parseTypeToColor(state.pokemon.types.first()) else Color.Transparent,
                    onClick = {
                        navController.navigate(Screen.Detail.navArgs(state.pokemon.name))
                    }
                )
            }
        }
        StandardLoadingErrorScreen(
            hasError = state.hasError,
            errorMessage = state.errorMessage.asString(context)
        )
    }
}