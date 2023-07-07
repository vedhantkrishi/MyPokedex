package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationIvX(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearlX,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilverX,
    val platinum: PlatinumX
)