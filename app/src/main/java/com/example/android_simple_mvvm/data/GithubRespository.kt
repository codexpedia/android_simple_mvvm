package com.example.android_simple_mvvm.data

import com.example.android_simple_mvvm.data.api.GithubApi
import com.example.android_simple_mvvm.data.model.GithubAccount
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubRespository(val githubApi: GithubApi) {

    fun fetchGithubAccount(name : String) : Observable<GithubAccount> {
        return Observable.create { emitter ->

            githubApi.getGithubAccount(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    if (it.body() != null) {
                        emitter.onNext(it.body()!!)
                    }
                }, {
                    it.printStackTrace()
                })

        }
    }

}