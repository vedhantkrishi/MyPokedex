package com.example.mypokedex.feature_pokedex.presentation.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon
import com.example.mypokedex.feature_pokedex.util.parseStatToAbbr
import com.example.mypokedex.feature_pokedex.util.parseStatToColor

@Composable
fun BaseStats(
    modifier: Modifier = Modifier,
    pokemonInfo: Pokemon,
) {
    val maxStatValue = pokemonInfo.stats.maxOf { it.base_stat }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        pokemonInfo.stats.forEach { stat ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = parseStatToAbbr(stat),
                )
                Text(
                    text = stat.base_stat.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(80.dp)
                        .graphicsLayer { translationX = 60.dp.toPx() }
                )
                StatItem(
                    statValue = stat.base_stat,
                    maxStatValue = maxStatValue,
                    statColor = parseStatToColor(stat)
                )
            }
        }
    }
}