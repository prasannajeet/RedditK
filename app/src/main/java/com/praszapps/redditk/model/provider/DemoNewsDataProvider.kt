package com.praszapps.redditk.model.provider

import com.praszapps.redditk.model.pojo.RedditNewsItem
import rx.Observable

class DemoNewsDataProvider {
    fun getDummyNews(): Observable<List<RedditNewsItem>> {

        return Observable.create {

            subscriber ->
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}