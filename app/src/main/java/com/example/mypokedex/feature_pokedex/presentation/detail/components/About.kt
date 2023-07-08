package com.example.mypokedex.feature_pokedex.presentation.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mypokedex.R
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon
import com.example.mypokedex.feature_pokedex.presentation.home.components.ItemTypeStatAb
import com.example.mypokedex.ui.theme.spacing

@ExperimentalFoundationApi
@Composable
fun About(
    pokemonInfo: Pokemon,
    color: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = MaterialTheme.spacing.extraLarge,
                alignment = Alignment.CenterHorizontally
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {
            CharacteristicsAbout(
                painter = R.drawable.ic_balance,
                value = pokemonInfo.weight.toString(),
                dataUnit = "Kg"
            )
            Divider(
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .height(50.dp)
                    .width(2.dp)
            )
            CharacteristicsAbout(
                painter = R.drawable.ic_height,
                value = pokemonInfo.height.toString(),
                dataUnit = "m"
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
        Text(
            text = stringResource(R.string.abilities),
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(pokemonInfo.abilities) { ability ->
                ItemTypeStatAb(
                    text = ability,
                    boxColor = color,
                    boxWidth = 130.dp,
                    boxHeight = 40.dp,
                    boxShape = RoundedCornerShape(16.dp)
                )
            }
        }
    }
}