package com.floriantrecul.findmeadeveloper.data.mapper

import com.floriantrecul.findmeadeveloper.data.entity.RepositoryEntity
import com.floriantrecul.findmeadeveloper.domain.model.Repository

class RepositoryMapper : Mapper<RepositoryEntity, Repository> {

    override fun mapFromEntity(type: RepositoryEntity): Repository {
        return Repository(
            id = type.id,
            name = type.name,
            fullName = type.fullName,
            repoUrl = type.repoUrl,
            stargazersCount = type.stargazersCount,
            watchersCount = type.watchersCount,
            language = type.language,
            forksCount = type.forksCount
        )
    }

    override fun mapToEntity(type: Repository): RepositoryEntity {
        return RepositoryEntity(
            id = type.id,
            name = type.name,
            fullName = type.fullName,
            repoUrl = type.repoUrl,
            stargazersCount = type.stargazersCount,
            watchersCount = type.watchersCount,
            language = type.language,
            forksCount = type.forksCount
        )
    }

}