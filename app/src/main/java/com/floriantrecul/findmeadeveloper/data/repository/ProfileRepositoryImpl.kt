package com.floriantrecul.findmeadeveloper.data.repository

import com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper.ProfileDtoMapper
import com.floriantrecul.findmeadeveloper.data.data_source.remote.service.FindMeADeveloperApi
import com.floriantrecul.findmeadeveloper.data.mapper.ProfileMapper
import com.floriantrecul.findmeadeveloper.domain.model.Profile
import com.floriantrecul.findmeadeveloper.domain.repository.ProfileRepository

class ProfileRepositoryImpl(
    private val findMeADeveloperApi: FindMeADeveloperApi,
    private val profileDtoMapper: ProfileDtoMapper,
    private val profileMapper: ProfileMapper
) : ProfileRepository {

    override suspend fun getProfile(profileId: String): Profile =
        profileMapper.mapFromEntity(
            profileDtoMapper.mapToEntity(
                findMeADeveloperApi.getProfile(
                    profileId
                )
            )
        )
}