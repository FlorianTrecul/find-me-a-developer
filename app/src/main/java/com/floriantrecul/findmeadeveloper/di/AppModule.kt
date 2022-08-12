package com.floriantrecul.findmeadeveloper.di

import com.floriantrecul.findmeadeveloper.domain.repository.ProfileRepository
import com.floriantrecul.findmeadeveloper.domain.use_case.GetProfileUseCase
import com.floriantrecul.findmeadeveloper.domain.use_case.GetRepositoriesUseCase
import com.floriantrecul.findmeadeveloper.domain.use_case.ProfileUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProfileUsesCases(
        profileRepository: ProfileRepository
    ): ProfileUsesCases =
        ProfileUsesCases(
            getProfile = GetProfileUseCase(profileRepository = profileRepository),
            getRepositories = GetRepositoriesUseCase(profileRepository = profileRepository)
        )
}