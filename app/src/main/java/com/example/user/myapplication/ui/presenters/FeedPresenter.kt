package com.example.user.myapplication.ui.presenters

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.user.myapplication.repository.FeedRepository
import com.example.user.myapplication.MainApplication
import com.example.user.myapplication.models.FeedItemEntity
import com.example.user.myapplication.ui.activities.PostActivity
import com.example.user.myapplication.ui.views.FeedView
import com.example.user.myapplication.utils.Consts
import javax.inject.Inject

@InjectViewState
class FeedPresenter : MvpPresenter<FeedView>() {

    var beginFrom: String = ""

    @Inject
    lateinit var feedRepository: FeedRepository
    @Inject
    lateinit var context : Context

    init {
        MainApplication.appComponent.inject(this)

        feedRepository.getFeed()
                .subscribe { feed: List<FeedItemEntity>? ->
                    viewState.setFeed(feed!!)
                    if (!feed.isEmpty())
                        beginFrom = feed.get(feed.size - 1).name
                    else
                        getMorePosts()
                }
    }

    fun getMorePosts() {
        feedRepository.loadPosts(beginFrom).subscribe()
    }

    fun navigateToPost(activity: Activity, url : String){
        val intent = Intent(activity, PostActivity::class.java)
        intent.putExtra(Consts.BUNDLE_URL, url)
        activity.startActivity(intent)
    }

}