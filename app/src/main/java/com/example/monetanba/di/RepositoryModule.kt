package com.example.monetanba.di

import com.example.monetanba.data.domain.repository.NbaRepository
import com.example.monetanba.data.domain.repository.NbaRepositoryImpl
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
    abstract fun bindNbaRepository(
        nbaRepositoryImpl: NbaRepositoryImpl
    ): NbaRepository
}