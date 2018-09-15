package com.example.user.myapplication.di

import com.example.user.myapplication.repository.FeedRepository
import com.example.user.myapplication.repository.FeedRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeedRepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(): FeedRepository = FeedRepositoryImpl()

}