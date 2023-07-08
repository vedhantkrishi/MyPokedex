package com.example.mypokedex.feature_pokedex.presentation.moves

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypokedex.R
import com.example.mypokedex.core.components.ListAnimation
import com.example.mypokedex.core.components.ListItem
import com.example.mypokedex.core.components.TopBar
import com.example.mypokedex.core.presentation.StandardLoadingErrorScreen
import com.example.mypokedex.core.util.asString

@ExperimentalFoundationApi
@Composable
fun MoveScreen(
    navController: NavController,
    context: Context,
    viewModel: MoveViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = stringResource(R.string.moves),
            onClickIcon1 = navController::navigateUp
        )
        ListAnimation(
            items = state.moves,
            isLoading = state.isLoading
        ) { index, move ->
            val size = state.moves.size
            if (index >= size - 1 && !state.isLoading) {
                viewModel.getMoves()
            }
            ListItem(
                text = move.name,
                seconderyText = move.type,
                number = move.id,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    StandardLoadingErrorScreen(
        hasError = state.hasError,
        errorMessage = state.errorMessage.asString(context),
        isLoading = state.isLoading,
        items = state.moves.toList()
    )}