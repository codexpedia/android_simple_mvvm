package com.example.android_simple_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android_simple_mvvm.R
import com.example.android_simple_mvvm.util.RepositoryFactory
import com.example.android_simple_mvvm.util.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this, ViewModelFactory(RepositoryFactory.createGithubRepository())).get(MainActivityViewModel::class.java)

        mainActivityViewModel.githubAccount.observe(this, Observer {
            tv_content.text = it.toString()
        })


        mainActivityViewModel.getGithubAccount("google")
    }
}
