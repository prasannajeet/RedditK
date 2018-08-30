package com.praszapps.redditk.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.praszapps.redditk.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.newsListFragmentHolder, NewsFragment()).commit()
    }
}