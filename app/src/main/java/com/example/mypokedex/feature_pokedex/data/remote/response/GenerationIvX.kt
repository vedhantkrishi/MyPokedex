package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationIvX(
    @SerializedName("diamond-pearl")
    val diamond_pearl: DiamondPearlX,
    @SerializedName("heartgold-soulsilver")
    val heartgold_soulsilver: HeartgoldSoulsilverX,
    val platinum: PlatinumX
)