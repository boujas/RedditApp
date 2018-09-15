package com.example.user.myapplication.repository

import android.content.Context
import com.example.user.myapplication.MainApplication
import com.example.user.myapplication.db.RoomDataSource
import com.example.user.myapplication.models.FeedItemEntity
import com.example.user.myapplication.models.RedditResponse
import com.example.user.myapplication.net.RedditService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedRepositoryImpl : FeedRepository {

    @Inject
    lateinit var redditService: RedditService
    @Inject
    lateinit var roomDataSource: RoomDataSource
    @Inject
    lateinit var context:Context

    init {
        MainApplication.appComponent.inject(this)
    }

    override fun getFeed(): Flowable<List<FeedItemEntity>> {
        return roomDataSource
                .weatherSearchCityDao().getAllCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveFeed(list: List<FeedItemEntity>) {
        Completable.fromCallable {
            RoomDataSource.getInstance(context).weatherSearchCityDao().insertAll(list)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    override fun loadPosts(beginFrom: String) : Single<RedditResponse> {
        return redditService.requestCityAddressByName(beginFrom, "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess { t ->  saveFeed(t.data.children.map { child -> child.data })}
    }

}