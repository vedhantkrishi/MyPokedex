package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationVX(
    @SerializedName("black-white")
    val black_white: BlackWhiteX
)