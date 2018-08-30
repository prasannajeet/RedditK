package com.praszapps.redditk.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.praszapps.redditk.R
import com.praszapps.redditk.model.pojo.RedditNewsItem
import com.praszapps.redditk.util.extensions.commentPluralOrSingular
import com.praszapps.redditk.util.extensions.getFriendlyTime
import com.praszapps.redditk.util.extensions.inflate
import com.praszapps.redditk.util.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsItemTypeAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = item.numComments.commentPluralOrSingular(item.numComments)
            time.text = item.created.getFriendlyTime()
        }
    }
}