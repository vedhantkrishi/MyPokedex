package com.example.mypokedex.feature_pokedex.presentation.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mypokedex.feature_pokedex.presentation.home.components.ItemTypeStatAb
import com.example.mypokedex.feature_pokedex.util.parseTypeToColor
import com.example.mypokedex.ui.theme.spacing

@Composable
fun BasicInfoPokemon(
    modifier: Modifier = Modifier,
    name: String,
    index: String,
    types: List<String>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "#$index",
                modifier = Modifier.align(Alignment.Bottom),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Row(
            modifier = Modifier.padding(start = MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ItemTypeStatAb(
                text = types.first(),
                boxColor = Color.White.copy(alpha = 0.2f)
            )
            if (types.size > 1) {
                ItemTypeStatAb(
                    text = types[1],
                    boxColor = parseTypeToColor(types[1])
                )
            }
        }
    }
}