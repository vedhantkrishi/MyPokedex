package com.example.mypokedex.feature_pokedex.presentation.detail.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mypokedex.R
import com.example.mypokedex.core.components.StartAnimation
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon
import com.example.mypokedex.feature_pokedex.presentation.home.components.ItemTypeStatAb
import com.example.mypokedex.feature_pokedex.util.Page
import com.example.mypokedex.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun InfoTabs(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    backgroundColor: Color,
    pages: List<Page>,
    pokemonInfo: Pokemon
) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        indicator = {  },
        divider = {  }
    ) {
        pages.forEachIndexed { index, page ->
            ItemTypeStatAb(
                text = page.title,
                selected = index == pagerState.currentPage,
                boxColor = backgroundColor,
                modifier = modifier
                    .height(40.dp)
                    .clip(CircleShape)
                    .clickable {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
            )
        }
    }
    HorizontalPager(
        count = pages.size,
        state = pagerState
    ) {
        val page = pages[pagerState.currentPage]
        val color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (page) {
                is Page.About -> {
                    StartAnimation(
                        enterTransition = slideInVertically(
                            animationSpec = tween(400)
                        ) + scaleIn() + fadeIn(),
                        exitTransition = slideOutVertically(
                            animationSpec = tween(400)
                        ) + scaleOut() + fadeOut()
                    ) {
                        About(
                            pokemonInfo = pokemonInfo,
                            color = color
                        )
                    }

                }
                is Page.BaseStats -> {
                    StartAnimation(
                        enterTransition = slideInVertically(
                            animationSpec = tween(400)
                        ) + scaleIn() + fadeIn(),
                        exitTransition = slideOutVertically(
                            animationSpec = tween(400)
                        ) + scaleOut() + fadeOut()
                    ) {
                        BaseStats(
                            pokemonInfo = pokemonInfo,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                is Page.Moves -> {
                    StartAnimation(
                        enterTransition = slideInVertically(
                            animationSpec = tween(400)
                        ) + scaleIn() + fadeIn(),
                        exitTransition = slideOutVertically(
                            animationSpec = tween(400)
                        ) + scaleOut() + fadeOut()
                    ) {
                        LazyVerticalGrid(
                            cells = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
                            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
                        ) {
////                            Limit of 10 moves
//                            val moves = if (pokemonInfo.moves.size >= 10) {
//                                pokemonInfo.moves.subList(0, 10)
//                            } else {
//                                pokemonInfo.moves
//                            }
                            val moves = pokemonInfo.moves
                            items(moves) {
                                ItemTypeStatAb(
                                    text = it,
                                    boxHeight = 35.dp,
                                    boxColor = color
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
