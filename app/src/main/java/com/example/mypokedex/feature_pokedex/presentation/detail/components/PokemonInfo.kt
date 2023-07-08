package com.example.mypokedex.feature_pokedex.presentation.detail.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mypokedex.core.components.RotatingImageAnimation
import com.example.mypokedex.core.components.SvgImage
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon
import com.example.mypokedex.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.example.mypokedex.R
import com.example.mypokedex.feature_pokedex.util.Page

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun PokemonInfo(
    modifier: Modifier = Modifier,
    pokemonInfo: Pokemon,
    pagerState: PagerState,
    backgroundColor: Color,
    pages: List<Page>,
    boxCornerShape: Shape = RoundedCornerShape(32.dp, 32.dp)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        RotatingImageAnimation(
            image = R.drawable.ic_pokeball,
            size = 200.dp,
            modifier = Modifier.graphicsLayer { translationY = 50f }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp)
                .clip(boxCornerShape)
                .background(MaterialTheme.colors.background)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.description),
                    color = LocalContentColor.current.copy(ContentAlpha.disabled),
                    textAlign = TextAlign.Justify
                )
                InfoTabs(
                    pagerState = pagerState,
                    backgroundColor = backgroundColor,
                    pages = pages,
                    pokemonInfo = pokemonInfo
                )
            }
        }
        SvgImage(
            imgUrl = pokemonInfo.imageUrl,
            modifier = Modifier.size(200.dp)
        )
    }
}