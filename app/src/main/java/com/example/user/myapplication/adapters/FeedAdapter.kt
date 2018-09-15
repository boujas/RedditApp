package com.example.user.myapplication.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.user.myapplication.R
import com.example.user.myapplication.models.FeedItemEntity
import android.content.Context

class FeedAdapter(val items: ArrayList<FeedItemEntity>, val context: Context) : RecyclerView.Adapter<FeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        return FeedItemViewHolder(LayoutInflater.from(context).inflate(R.layout.view_feed_item, parent, false))
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(items[position]);
    }

    override fun getItemCount(): Int {
        return items.size
    }

}