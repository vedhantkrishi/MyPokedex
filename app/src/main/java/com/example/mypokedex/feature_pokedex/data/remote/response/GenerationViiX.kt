package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationViiX(
    val icons: IconsX,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoonX
)