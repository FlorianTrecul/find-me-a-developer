package com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper

import com.floriantrecul.findmeadeveloper.data.data_source.remote.dto.RepositoryDto
import com.floriantrecul.findmeadeveloper.data.entity.RepositoryEntity
import com.floriantrecul.findmeadeveloper.data.mapper.Mapper

class RepositoryDtoMapper : Mapper<RepositoryEntity, RepositoryDto?> {

    override fun mapFromEntity(type: RepositoryEntity): RepositoryDto? {
        return null
    }

    override fun mapToEntity(type: RepositoryDto?): RepositoryEntity {
        val repository = type!!
        return RepositoryEntity(
            id = repository.id,
            name = repository.name,
            fullName = repository.fullName,
            repoUrl = repository.repoUrl,
            stargazersCount = repository.stargazersCount,
            watchersCount = repository.watchersCount,
            language = repository.language,
            forksCount = repository.forksCount
        )
    }


}