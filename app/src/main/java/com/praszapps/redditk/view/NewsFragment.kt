package com.praszapps.redditk.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.praszapps.redditk.R
import com.praszapps.redditk.model.NewsRepository
import com.praszapps.redditk.view.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : RxBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        initAdapter()
        getNews(savedInstanceState)
    }

    private fun initList() {
        newsList.layoutManager = LinearLayoutManager(activity)
        newsList.setHasFixedSize(true)
    }


    private fun initAdapter() {
        newsList.adapter.let {
            newsList.adapter = NewsAdapter()
        }
    }

    private fun getNews(savedInstanceState: Bundle?) {
        savedInstanceState.let {

            val subscription: Subscription = NewsRepository().getNews()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe (
                            { retrievedNews ->
                                (newsList.adapter as NewsAdapter).addNews(retrievedNews)
                            },
                            { e ->
                                e.printStackTrace()
                            }
                    )
            subscriptions.add(subscription)
        }
    }
}