package com.example.mypokedex.feature_pokedex.data.util

import com.example.mypokedex.feature_pokedex.data.local.PokemonEntity
import com.example.mypokedex.feature_pokedex.data.remote.response.MoveResponse
import com.example.mypokedex.feature_pokedex.data.remote.response.PokemonResponse
import com.example.mypokedex.feature_pokedex.data.remote.response.ResultX
import com.example.mypokedex.feature_pokedex.domain.model.MoveEntry
import com.example.mypokedex.feature_pokedex.domain.model.Pokemon
import com.example.mypokedex.feature_pokedex.domain.model.TypeEntry
import com.example.mypokedex.feature_pokedex.util.parseTypeToColor

fun PokemonResponse.toPokemon(): Pokemon {
    return Pokemon(
        name = name,
        imageUrl = sprites.other.dream_world.front_default,
        height = height,
        types = types.map { it.type.name },
        weight = weight,
        moves = moves.map { it.move.name },
        stats = stats,
        abilities = abilities.map { it.ability.name },
        id = id
    )
}

fun ResultX.toTypeEntry(): TypeEntry {
    return TypeEntry(
        name = name,
        color = parseTypeToColor(name)
    )
}

fun MoveResponse.toMoveEntry(): MoveEntry {
    return MoveEntry(
        name = name,
        type = type.name,
        id = id
    )
}

fun Pokemon.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        name = name,
        imageUrl = imageUrl,
        height = height,
        types = types,
        weight = weight,
        moves = moves,
        stats = stats,
        abilities = abilities,
        id = id,
        isSelectedFavorite = isFavorite
    )
}

fun PokemonEntity.toPokemon(): Pokemon {
    return Pokemon(
        name = name,
        imageUrl = imageUrl,
        height = height,
        types = types,
        weight = weight,
        moves = moves,
        stats = stats,
        abilities = abilities,
        id = id,
        isFavorite = isSelectedFavorite
    )
}