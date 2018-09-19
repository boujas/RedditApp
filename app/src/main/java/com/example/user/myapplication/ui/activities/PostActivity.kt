package com.example.user.myapplication.ui.activities

import android.os.Bundle
import android.app.Activity
import com.example.user.myapplication.R
import com.example.user.myapplication.utils.Consts

import com.example.user.myapplication.ui.fragments.PostFragment

class PostActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        val url: String = intent.getStringExtra(Consts.BUNDLE_URL)
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, PostFragment.newInstance(url), null)
                .commit()
    }

}