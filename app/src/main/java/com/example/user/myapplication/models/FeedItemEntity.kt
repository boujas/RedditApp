package com.example.user.myapplication.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "TABLE_FEED_ITEMS")
data class FeedItemEntity(
        @PrimaryKey
        var name: String,
        var thumbnail: String,
        var title: String,
        var score: Int,
        var created : String,
        var num_comments: String,
        var author: String,
        var domain : String,
        var permalink: String)