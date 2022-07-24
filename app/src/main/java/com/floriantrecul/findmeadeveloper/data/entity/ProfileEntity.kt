package com.floriantrecul.findmeadeveloper.data.entity

data class ProfileEntity(
    val login: String,
    val id: Int,
    val profileImageUrl: String,
    val profileUrl: String,
    val organizationsUrl: List<String>,
    val name: String,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val email: String? = null,
    val bio: String? = null,
    val twitterUsername: String? = null,
    val publicRepos: Int = 0,
    val followers: Int = 0,
    val following: Int = 0,
    val createdAt: String
)