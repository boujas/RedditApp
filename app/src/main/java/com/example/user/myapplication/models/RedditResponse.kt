package com.example.user.myapplication.models

data class RedditResponse(var kind: String, var data: Data)

data class Data(var dist: Int, var children: List<Child>)

data class Child (var kind : String, var data : FeedItemEntity)

