package com.example.user.myapplication.ui

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.user.myapplication.repository.FeedRepository
import com.example.user.myapplication.MainApplication
import com.example.user.myapplication.models.FeedItemEntity
import javax.inject.Inject

@InjectViewState
class FeedPresenter : MvpPresenter<FeedView>() {

    var beginFrom: String = ""

    @Inject
    lateinit var feedRepository: FeedRepository

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

}