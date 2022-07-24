package com.floriantrecul.findmeadeveloper.data.data_source.remote.service

import com.floriantrecul.findmeadeveloper.data.data_source.remote.dto.ProfileDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FindMeADeveloperApi {

    @GET("users/{id}")
    suspend fun getProfile(
        @Path("id") profileId: String
    ) : ProfileDto
}