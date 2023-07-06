package com.example.mypokedex.feature_pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mypokedex.feature_pokedex.data.util.PokemonConverters

@TypeConverters(PokemonConverters::class)
@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
abstract class PokemonDB: RoomDatabase() {
    abstract val dao: PokemonDao
}