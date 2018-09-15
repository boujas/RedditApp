package com.example.user.myapplication.di

import android.content.Context
import com.example.user.myapplication.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val weatherApplication: MainApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = weatherApplication

}