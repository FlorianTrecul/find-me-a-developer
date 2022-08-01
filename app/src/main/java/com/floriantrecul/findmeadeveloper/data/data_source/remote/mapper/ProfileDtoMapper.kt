package com.floriantrecul.findmeadeveloper.data.data_source.remote.mapper

import com.floriantrecul.findmeadeveloper.data.data_source.remote.dto.ProfileDto
import com.floriantrecul.findmeadeveloper.data.entity.ProfileEntity
import com.floriantrecul.findmeadeveloper.data.mapper.Mapper

class ProfileDtoMapper : Mapper<ProfileEntity, ProfileDto?> {

    override fun mapFromEntity(type: ProfileEntity): ProfileDto? {
        return null
    }

    override fun mapToEntity(type: ProfileDto?): ProfileEntity {
        val profile = type!!
        return ProfileEntity(
            login = profile.login,
            id = profile.id,
            profileImageUrl = profile.profileImageUrl,
            profileUrl = profile.profileUrl,
            name = profile.name,
            company = profile.company,
            blog = profile.blog,
            location = profile.location,
            email = profile.email,
            bio = profile.bio,
            twitterUsername = profile.twitterUsername,
            publicRepos = profile.publicRepos,
            followers = profile.followers,
            following = profile.following,
            createdAt = profile.createdAt
        )
    }
}