package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class OtherX(
    val dream_world: DreamWorldX,
    val home: HomeX,
    @SerializedName("official-artwork")
    val official_artwork: OfficialArtworkX
)