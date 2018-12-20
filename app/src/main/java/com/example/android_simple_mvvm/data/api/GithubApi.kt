package com.example.android_simple_mvvm.data.api

import com.example.android_simple_mvvm.data.model.GithubAccount
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("/users/{username}")
    fun getGithubAccount(@Path("username") username: String): Single<Response<GithubAccount>>
}