package com.example.mypokedex.core.components

import android.content.Context
import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mypokedex.core.presentation.SplashScreen
import com.example.mypokedex.core.util.Screen
import com.example.mypokedex.feature_pokedex.presentation.detail.DetailScreen
import com.example.mypokedex.feature_pokedex.presentation.favorites.FavoritesListScreen
import com.example.mypokedex.feature_pokedex.presentation.home.HomeScreen
import com.example.mypokedex.feature_pokedex.presentation.moves.MoveScreen
import com.example.mypokedex.feature_pokedex.presentation.pokemon_list.PokemonListScreen
import com.example.mypokedex.feature_pokedex.presentation.types.TypeScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun Navigation(
    navController: NavHostController,
    pagerState: PagerState,
    context: Context
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ) {
            StartAnimation(
                enterTransition = slideInHorizontally() + fadeIn(),
                exitTransition = slideOutHorizontally() + fadeOut()
            ) {
                HomeScreen(navController = navController, context = context)
            }
        }
        composable(
            route = Screen.Detail.route +"/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            StartAnimation(
                enterTransition = scaleIn() + fadeIn(),
                exitTransition = scaleOut() + fadeOut()
            ) {
                DetailScreen(navController, context, pagerState)
            }
        }
        composable(route = Screen.PokemonList.route) {
            StartAnimation(
                enterTransition = slideInHorizontally() + fadeIn(),
                exitTransition = slideOutHorizontally() + fadeOut()
            ) {
                PokemonListScreen(navController, context)
            }
        }
        composable(Screen.Move.route) {
            StartAnimation(
                enterTransition = slideInHorizontally() + fadeIn(),
                exitTransition = slideOutHorizontally() + fadeOut()
            ) {
                MoveScreen(navController, context)
            }
        }
        composable(Screen.Type.route) {
            StartAnimation(
                enterTransition = slideInHorizontally() + fadeIn(),
                exitTransition = slideOutHorizontally() + fadeOut()
            ) {
                TypeScreen(navController, context)
            }
        }
        composable(Screen.Favorite.route) {
            StartAnimation(
                enterTransition = slideInHorizontally() + fadeIn(),
                exitTransition = slideOutHorizontally() + fadeOut()
            ) {
                FavoritesListScreen(navController)
            }
        }
    }
}