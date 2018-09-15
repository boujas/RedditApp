package com.example.user.myapplication.di

import com.example.user.myapplication.repository.FeedRepositoryImpl
import com.example.user.myapplication.ui.FeedPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(NetModule::class, RoomModule::class, FeedRepositoryModule::class, AppModule::class))
@Singleton
interface AppComponent {

    fun inject(feedPresenter: FeedPresenter)

    fun inject(feedRepositoryImpl: FeedRepositoryImpl)

}