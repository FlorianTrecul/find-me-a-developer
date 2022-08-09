package com.floriantrecul.findmeadeveloper.data.repository

import com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper.ProfileDtoMapper
import com.floriantrecul.findmeadeveloper.data.data_source.remote.service.FindMeADeveloperApi
import com.floriantrecul.findmeadeveloper.data.mapper.ProfileMapper
import com.floriantrecul.findmeadeveloper.domain.model.Profile
import com.floriantrecul.findmeadeveloper.domain.repository.ProfileRepository
import com.floriantrecul.findmeadeveloper.util.ExceptionError
import com.floriantrecul.findmeadeveloper.util.Result
import com.squareup.moshi.JsonDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.net.UnknownHostException

class ProfileRepositoryImpl(
    private val findMeADeveloperApi: FindMeADeveloperApi,
    private val profileDtoMapper: ProfileDtoMapper,
    private val profileMapper: ProfileMapper
) : ProfileRepository {

    override suspend fun getProfile(profileUsername: String): Flow<Result<Profile>> = flow {
        try {
            val response = findMeADeveloperApi.getProfile(profileUsername = profileUsername)
            emit(
                Result.Success(
                    data = profileMapper.mapFromEntity(
                        profileDtoMapper.mapToEntity(
                            response
                        )
                    )
                )
            )
        } catch (e: Exception) {
            Timber.d("error e $e")
            val error = when (e) {
                is HttpException -> Result.Error(
                    title = ExceptionError.HTTP_EXCEPTION.title,
                    message = ExceptionError.HTTP_EXCEPTION.message
                )
                is UnknownHostException -> Result.Error(
                    title = ExceptionError.UNKNOWN_HOST_EXCEPTION.title,
                    message = ExceptionError.UNKNOWN_HOST_EXCEPTION.message
                )
                is JsonDataException -> Result.Error(
                    title = ExceptionError.JSON_DATA_EXCEPTION.title,
                    message = ExceptionError.JSON_DATA_EXCEPTION.message
                )
                else -> Result.Error(
                    title = ExceptionError.ERROR_EXCEPTION.title,
                    message = ExceptionError.ERROR_EXCEPTION.message
                )
            }
            emit(error)
        }
    }
}