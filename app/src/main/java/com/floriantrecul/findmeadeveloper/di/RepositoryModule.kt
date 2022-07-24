package com.floriantrecul.findmeadeveloper.di

import com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper.ProfileDtoMapper
import com.floriantrecul.findmeadeveloper.data.data_source.remote.service.FindMeADeveloperApi
import com.floriantrecul.findmeadeveloper.data.mapper.ProfileMapper
import com.floriantrecul.findmeadeveloper.data.repository.ProfileRepositoryImpl
import com.floriantrecul.findmeadeveloper.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProfileRepository(
        findMeADeveloperApi: FindMeADeveloperApi,
        profileDtoMapper: ProfileDtoMapper,
        profileMapper: ProfileMapper
    ): ProfileRepository =
        ProfileRepositoryImpl(findMeADeveloperApi, profileDtoMapper, profileMapper)

    @Singleton
    @Provides
    fun provideProfileMapper(): ProfileMapper = ProfileMapper()
}