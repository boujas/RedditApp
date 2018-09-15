package com.example.user.myapplication.ui

import com.arellomobile.mvp.MvpView
import com.example.user.myapplication.models.FeedItemEntity

interface FeedView : MvpView {

    fun setFeed(item: List<FeedItemEntity> )

}