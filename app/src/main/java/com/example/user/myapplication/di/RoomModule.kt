package com.example.user.myapplication.di

import android.content.Context
import com.example.user.myapplication.db.RoomDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule (context: Context) {

    val context = context

    @Provides
    @Singleton
    fun provideRoomCurrencyDataSource() =
            RoomDataSource.getInstance(context)

}