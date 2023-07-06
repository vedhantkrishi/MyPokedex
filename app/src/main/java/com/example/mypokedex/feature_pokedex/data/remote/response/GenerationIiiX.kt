package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationIiiX(
    val emerald: EmeraldX,
    @SerializedName("firered-leafgreen")
    val firered_leafgreen: FireredLeafgreenX,
    @SerializedName("ruby-sapphire")
    val ruby_sapphire: RubySapphireX
)