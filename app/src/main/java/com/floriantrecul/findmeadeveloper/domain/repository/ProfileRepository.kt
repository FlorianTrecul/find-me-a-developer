package com.floriantrecul.findmeadeveloper.domain.repository

import com.floriantrecul.findmeadeveloper.domain.model.Profile

interface ProfileRepository {

    suspend fun getProfile(profileId: String): Profile

}