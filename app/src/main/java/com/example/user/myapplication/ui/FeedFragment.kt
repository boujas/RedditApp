package com.example.user.myapplication.ui

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.user.myapplication.adapters.PaginationScrollListener


import com.example.user.myapplication.R
import com.example.user.myapplication.adapters.FeedAdapter
import com.example.user.myapplication.models.FeedItemEntity

class FeedFragment : MvpFragment(), FeedView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var feedPresenter: FeedPresenter

    var adapter: FeedAdapter? = null
    var feed: ArrayList<FeedItemEntity> = ArrayList();
    var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        setupRecyclerView()
        return view
    }

    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    private fun setupRecyclerView() {
        adapter = FeedAdapter(feed, activity)
        val mLayoutManager = LinearLayoutManager(activity.applicationContext)
        recyclerView?.setLayoutManager(mLayoutManager)
        recyclerView?.setItemAnimator(DefaultItemAnimator())
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recyclerView?.setAdapter(adapter)
        recyclerView?.addOnScrollListener(object : PaginationScrollListener(mLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                isLoading = true
                getMoreItems()
            }
        })
    }

    override fun setFeed(item: List<FeedItemEntity>) {
        feed.addAll(item)
        adapter?.notifyDataSetChanged()
    }

    private fun getMoreItems() {
        isLoading = false
        feedPresenter.getMorePosts()
    }

}
