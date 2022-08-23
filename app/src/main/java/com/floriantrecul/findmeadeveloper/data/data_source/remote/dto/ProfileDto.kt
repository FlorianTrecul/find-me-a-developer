package com.floriantrecul.findmeadeveloper.data.data_source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileDto(
    @Json(name = "login")
    val login: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "avatar_url")
    val profileImageUrl: String,
    @Json(name = "html_url")
    val profileUrl: String,
    @Json(name = "name")
    val name: String? = null ,
    @Json(name = "company")
    val company: String? = null,
    @Json(name = "blog")
    val blog: String? = null,
    @Json(name = "location")
    val location: String? = null,
    @Json(name = "email")
    val email: String? = null,
    @Json(name = "bio")
    val bio: String? = null,
    @Json(name = "twitter_username")
    val twitterUsername: String? = null,
    @Json(name = "public_repos")
    val publicRepos: Int = 0,
    @Json(name = "followers")
    val followers: Int = 0,
    @Json(name = "following")
    val following: Int = 0,
    @Json(name = "created_at")
    val createdAt: String
)