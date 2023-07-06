package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationIX(
    @SerializedName("red-blue")
    val red_blue: RedBlueX,
    val yellow: YellowX
)