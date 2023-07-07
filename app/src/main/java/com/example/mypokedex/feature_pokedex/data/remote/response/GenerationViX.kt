package com.example.mypokedex.feature_pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationViX(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphireX,
    @SerializedName("x-y")
    val xY: XYX
)