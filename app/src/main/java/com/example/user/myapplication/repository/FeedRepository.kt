package com.example.user.myapplication.repository

import android.content.Context
import com.example.user.myapplication.models.FeedItemEntity
import com.example.user.myapplication.models.RedditResponse
import io.reactivex.Flowable
import io.reactivex.Single

interface FeedRepository {

    fun loadPosts(beginFrom: String) : Single<RedditResponse>

    fun saveFeed(list: List<FeedItemEntity>)

    fun getFeed(): Flowable<List<FeedItemEntity>>

}