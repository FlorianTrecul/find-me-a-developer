package com.floriantrecul.findmeadeveloper.di

import com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper.ProfileDtoMapper
import com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper.RepositoryDtoMapper
import com.floriantrecul.findmeadeveloper.data.mapper.ProfileMapper
import com.floriantrecul.findmeadeveloper.data.mapper.RepositoryMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideProfileDtoMapper(): ProfileDtoMapper = ProfileDtoMapper()

    @Singleton
    @Provides
    fun provideProfileMapper(): ProfileMapper = ProfileMapper()

    @Singleton
    @Provides
    fun provideRepositoryDtoMapper(): RepositoryDtoMapper = RepositoryDtoMapper()

    @Singleton
    @Provides
    fun provideRepositoryMapper(): RepositoryMapper = RepositoryMapper()
}