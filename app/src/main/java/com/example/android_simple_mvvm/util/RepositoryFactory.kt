package com.example.android_simple_mvvm.util

import com.example.android_simple_mvvm.data.api.GithubApi
import com.example.android_simple_mvvm.data.GithubRespository

object RepositoryFactory {

    fun createGithubRepository() : GithubRespository {
        val githubApi = RestUtil.instance.retrofit.create(GithubApi::class.java)
        return GithubRespository(githubApi)
    }

}