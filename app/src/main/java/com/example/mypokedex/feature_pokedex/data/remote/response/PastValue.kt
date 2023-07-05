package com.example.mypokedex.feature_pokedex.data.remote.response

data class PastValue(
    val accuracy: Int,
    val effect_chance: Any,
    val effect_entries: List<Any>,
    val power: Int,
    val pp: Any,
    val type: Any,
    val version_group: VersionGroupXX
)