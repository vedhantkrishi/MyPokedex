package com.example.mypokedex.di

import com.example.mypokedex.feature_pokedex.data.repository.PokemonRepoImpl
import com.example.mypokedex.feature_pokedex.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPokemonRepository(
        repositoryImpl: PokemonRepoImpl
    ): PokemonRepository
}