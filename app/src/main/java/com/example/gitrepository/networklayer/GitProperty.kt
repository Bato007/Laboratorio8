package com.example.gitrepository.networklayer

import com.squareup.moshi.Json

data class GitProperty(
    @Json(name = "login") val userName: String,
    @Json(name = "avatar_url") val userImage: String,
    @Json(name = "repos_url") val repositoryUrl: String

)