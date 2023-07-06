package com.example.mypokedex.di

import android.app.Application
import androidx.room.Room
import com.example.mypokedex.core.util.Constants
import com.example.mypokedex.feature_pokedex.data.local.PokemonDB
import com.example.mypokedex.feature_pokedex.data.remote.PokemonApi
import com.example.mypokedex.feature_pokedex.data.util.GsonParser
import com.example.mypokedex.feature_pokedex.data.util.PokemonConverters
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonDatabase(app: Application): PokemonDB {
        return Room.databaseBuilder(
            app,
            PokemonDB::class.java,
            "pokemon_db"
        ).addTypeConverter(PokemonConverters(GsonParser(Gson())))
            .build()
    }
}