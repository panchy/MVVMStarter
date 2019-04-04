package com.panch.mvvmstarterapp.data.rest

data class DataWrapper<T>(
    val data: T? = null,
    val loading: Boolean = true
)

data class PhotoModel
    (
    val format: String,
    val width: Int,
    val height: Int,
    val filename: String,
    val id: Int,
    val author: String,
    val author_url: String,
    val post_url: String
)