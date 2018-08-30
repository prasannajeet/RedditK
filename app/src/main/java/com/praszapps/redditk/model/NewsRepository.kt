package com.praszapps.redditk.model

import com.praszapps.redditk.model.pojo.RedditNewsItem
import com.praszapps.redditk.model.provider.DemoNewsDataProvider
import com.praszapps.redditk.model.provider.NetworkNewsProvider
import rx.Observable

class NewsRepository {

    fun getNews(isDemoMode: Boolean = false): Observable<List<RedditNewsItem>> {

        if (!isDemoMode) {

            return Observable.create{

                subscriber ->

                val newsResponse = NetworkNewsProvider().getNews().execute()
                if (newsResponse.isSuccessful) {
                    val dataResponse = newsResponse.body()?.data
                    val news = dataResponse?.children?.map {
                        val item = it.data
                        RedditNewsItem(item.author, item.title, item.num_comments,
                                item.created, item.thumbnail, item.url)
                    }

                    subscriber.onNext(news)
                    subscriber.onCompleted()
                } else {
                    subscriber.onError(Throwable(newsResponse.message()))
                }
            }
        } else {
            return DemoNewsDataProvider().getDummyNews()
        }
    }
}