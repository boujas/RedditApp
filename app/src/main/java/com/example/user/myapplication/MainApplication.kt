package com.example.user.myapplication

import android.app.Application
import com.example.user.myapplication.di.*

class MainApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {

        appComponent = DaggerAppComponent.builder()
                .netModule(NetModule())
                .appModule(AppModule(this))
                .feedRepositoryModule(FeedRepositoryModule())
                .roomModule(RoomModule(this)).build()
    }

}