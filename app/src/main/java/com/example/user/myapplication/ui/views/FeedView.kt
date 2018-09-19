package com.example.user.myapplication.ui.views

import com.arellomobile.mvp.MvpView
import com.example.user.myapplication.models.FeedItemEntity

interface FeedView : MvpView {

    fun setFeed(item: List<FeedItemEntity> )

}