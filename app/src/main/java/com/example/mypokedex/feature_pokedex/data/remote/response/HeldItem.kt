package com.example.mypokedex.feature_pokedex.data.remote.response

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)