package com.example.android_simple_mvvm.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_simple_mvvm.data.GithubRespository
import com.example.android_simple_mvvm.ui.MainActivityViewModel

class ViewModelFactory(private val githubRespository: GithubRespository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(githubRespository) as T
    }

}