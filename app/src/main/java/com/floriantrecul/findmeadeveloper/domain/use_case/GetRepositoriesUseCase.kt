package com.floriantrecul.findmeadeveloper.domain.use_case

import com.floriantrecul.findmeadeveloper.domain.model.Repository
import com.floriantrecul.findmeadeveloper.domain.repository.ProfileRepository
import com.floriantrecul.findmeadeveloper.util.Result
import kotlinx.coroutines.flow.Flow

class GetRepositoriesUseCase(
    private val profileRepository: ProfileRepository
) {

    suspend operator fun invoke(profileUsername: String): Flow<Result<List<Repository>>> {
        return profileRepository.getRepositories(profileUsername = profileUsername)
    }

}