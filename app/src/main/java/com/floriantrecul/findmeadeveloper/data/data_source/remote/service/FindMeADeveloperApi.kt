package com.floriantrecul.findmeadeveloper.data.data_source.remote.service

import com.floriantrecul.findmeadeveloper.data.data_source.remote.dto.ProfileDto
import com.floriantrecul.findmeadeveloper.data.data_source.remote.dto.RepositoryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FindMeADeveloperApi {

    @GET("users/{profileUsername}")
    suspend fun getProfile(
        @Path("profileUsername") profileUsername: String
    ) : ProfileDto

    @GET("users/{profileUsername}/repos")
    suspend fun getRepositories(
        @Path("profileUsername") profileUsername: String
    ) : List<RepositoryDto>
}