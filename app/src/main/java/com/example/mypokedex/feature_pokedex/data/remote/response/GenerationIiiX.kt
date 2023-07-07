package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationIiiX(
    val emerald: EmeraldX,
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreenX,
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphireX
)