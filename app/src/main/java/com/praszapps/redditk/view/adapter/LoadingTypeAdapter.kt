package com.praszapps.redditk.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.praszapps.redditk.R
import com.praszapps.redditk.util.extensions.inflate

class LoadingTypeAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))
}