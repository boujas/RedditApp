package com.example.user.myapplication.net

import com.example.user.myapplication.models.RedditResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {

    @GET("best")
    fun requestCityAddressByName(
            @Query("after") after: String,
            @Query("limit") limit: String
    ): Single<RedditResponse>

}