package com.example.android_simple_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_simple_mvvm.data.model.GithubAccount
import com.example.android_simple_mvvm.data.GithubRespository

class MainActivityViewModel(val githubRespository: GithubRespository) : ViewModel() {

    private val _githubAccount : MutableLiveData<GithubAccount> = MutableLiveData()
    val githubAccount : LiveData<GithubAccount> = _githubAccount

    fun getGithubAccount(name : String) {
        githubRespository
            .fetchGithubAccount(name)
            .subscribe {
                _githubAccount.postValue(it)
            }
    }

}
