package com.example.user.myapplication.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.user.myapplication.models.FeedItemEntity
import io.reactivex.Flowable

@Dao
interface FeedDao {

    @Insert(onConflict = REPLACE)
    fun insertAll(feed: List<FeedItemEntity>)

    @Query("SELECT * FROM TABLE_FEED_ITEMS")
    fun getAllCities(): Flowable<List<FeedItemEntity>>

}