package com.floriantrecul.findmeadeveloper.domain.use_case

import com.floriantrecul.findmeadeveloper.domain.model.Profile
import com.floriantrecul.findmeadeveloper.domain.repository.ProfileRepository
import com.floriantrecul.findmeadeveloper.util.Result
import kotlinx.coroutines.flow.Flow

class GetProfileUseCase(
    private val profileRepository: ProfileRepository
) {

    suspend operator fun invoke(profileUsername: String): Flow<Result<Profile>> {
        return profileRepository.getProfile(profileUsername = profileUsername)
    }

}