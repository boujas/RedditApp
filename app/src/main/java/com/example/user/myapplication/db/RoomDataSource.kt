package com.example.user.myapplication.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.user.myapplication.models.FeedItemEntity
import com.example.user.myapplication.utils.Consts

@Database(entities = arrayOf(FeedItemEntity::class), version = 1)
abstract class RoomDataSource : RoomDatabase() {

    abstract fun weatherSearchCityDao(): FeedDao

    companion object {

        @Volatile private var INSTANCE: RoomDataSource? = null

        fun getInstance(context: Context): RoomDataSource =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        RoomDataSource::class.java, Consts.DB_NAME)
                        .build()
    }

}