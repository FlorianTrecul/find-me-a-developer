package com.floriantrecul.findmeadeveloper.util

sealed class Result<out T : Any> {
    object Empty : Result<Nothing>()
    object Loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val title: Int?, val message: Int?) : Result<Nothing>()


    val extractData: T?
        get() = when (this) {
            is Empty -> null
            is Loading -> null
            is Success -> data
            is Error -> null
        }
}