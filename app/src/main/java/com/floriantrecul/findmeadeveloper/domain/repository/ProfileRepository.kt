package com.floriantrecul.findmeadeveloper.domain.repository

import com.floriantrecul.findmeadeveloper.domain.model.Profile
import com.floriantrecul.findmeadeveloper.domain.model.Repository
import com.floriantrecul.findmeadeveloper.util.Result
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    suspend fun getProfile(profileUsername: String): Flow<Result<Profile>>

    suspend fun getRepositories(profileUsername: String): Flow<Result<List<Repository>>>

}