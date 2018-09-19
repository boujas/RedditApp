package com.example.user.myapplication.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.user.myapplication.utils.CommonUtil
import com.example.user.myapplication.models.FeedItemEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_feed_item.view.*

class FeedItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val txtTitle = view.txt_title
    val txtAuthor = view.txt_author
    val txtCommentsCount = view.txt_comments_count
    val txtRating = view.txt_rating
    val txtSource = view.txt_source
    val txtPostDate = view.txt_post_date
    val imgThumbnail = view.img_thumbnail
    val viewContainer = view.container

    fun bind(feedItem: FeedItemEntity, onClickListener: (String) -> Unit) {

        txtAuthor.setText(feedItem.author)
        txtTitle.setText(feedItem.title)
        txtRating.setText(CommonUtil.getCommentCount(feedItem.score))
        txtAuthor.setText(feedItem.author)
        txtAuthor.setText(feedItem.author)
        txtSource.setText(feedItem.domain)
        txtCommentsCount.setText(feedItem.num_comments)
        txtPostDate.setText(CommonUtil.getWeeksCount(feedItem.created))
        Picasso.get().load(feedItem.thumbnail).into(imgThumbnail)
        viewContainer.setOnClickListener {
            onClickListener.invoke(feedItem.permalink)
        }
    }

}