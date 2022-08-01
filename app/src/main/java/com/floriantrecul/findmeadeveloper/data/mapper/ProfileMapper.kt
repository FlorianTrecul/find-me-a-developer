package com.floriantrecul.findmeadeveloper.data.mapper

import com.floriantrecul.findmeadeveloper.data.entity.ProfileEntity
import com.floriantrecul.findmeadeveloper.domain.model.Profile

class ProfileMapper : Mapper<ProfileEntity, Profile> {

    override fun mapFromEntity(type: ProfileEntity): Profile {
        return Profile(
            login = type.login,
            id = type.id,
            profileImageUrl = type.profileImageUrl,
            profileUrl = type.profileUrl,
            name = type.name,
            company = type.company,
            blog = type.blog,
            location = type.location,
            email = type.email,
            bio = type.bio,
            twitterUsername = type.twitterUsername,
            publicRepos = type.publicRepos,
            followers = type.followers,
            following = type.following,
            createdAt = type.createdAt
        )
    }

    override fun mapToEntity(type: Profile): ProfileEntity {
        return ProfileEntity(
            login = type.login,
            id = type.id,
            profileImageUrl = type.profileImageUrl,
            profileUrl = type.profileUrl,
            name = type.name,
            company = type.company,
            blog = type.blog,
            location = type.location,
            email = type.email,
            bio = type.bio,
            twitterUsername = type.twitterUsername,
            publicRepos = type.publicRepos,
            followers = type.followers,
            following = type.following,
            createdAt = type.createdAt
        )
    }
}