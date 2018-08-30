package com.praszapps.redditk.model.pojo

import com.praszapps.redditk.util.AdapterConstants
import com.praszapps.redditk.view.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}