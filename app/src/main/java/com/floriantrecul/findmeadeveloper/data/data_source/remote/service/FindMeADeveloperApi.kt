package com.floriantrecul.findmeadeveloper.data.data_source.remote.service

import com.floriantrecul.findmeadeveloper.data.data_source.remote.dto.ProfileDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FindMeADeveloperApi {

    @GET("users/{profileUserName}")
    suspend fun getProfile(
        @Path("profileUserName") profileUserName: String
    ) : ProfileDto
}