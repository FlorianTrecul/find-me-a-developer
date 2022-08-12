package com.floriantrecul.findmeadeveloper.data.entity

data class RepositoryEntity(
    val id: Int,
    val name: String,
    val fullName: String,
    val repoUrl: String,
    val stargazersCount: Int = 0,
    val watchersCount: Int = 0,
    val language: String? = null,
    val forksCount: Int = 0
)