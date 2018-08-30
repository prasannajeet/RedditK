package com.praszapps.redditk.model.provider

import com.praszapps.redditk.model.network.RedditApi
import com.praszapps.redditk.model.pojo.RedditNewsItem
import com.praszapps.redditk.model.pojo.RedditNewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.Observable

class NetworkNewsProvider {

    private val redditApi: RedditApi
    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        redditApi = retrofit.create(RedditApi::class.java)
    }
    fun getNews(after: String = "", limit: String = "10"): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}