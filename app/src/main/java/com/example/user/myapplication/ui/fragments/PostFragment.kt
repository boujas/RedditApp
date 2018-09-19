package com.example.user.myapplication.ui.fragments

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

import com.example.user.myapplication.R
import com.example.user.myapplication.utils.Consts

class PostFragment : Fragment() {

    var mywebview: WebView? = null

    companion object {
        private val ARG_CAUGHT = "myFragment_caught"

        fun newInstance(url: String): PostFragment {
            val args: Bundle = Bundle()
            args.putSerializable(Consts.BUNDLE_URL, url)
            val fragment = PostFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        mywebview = view.findViewById(R.id.web_view) as WebView
        val url = arguments.getString(Consts.BUNDLE_URL)
        setWebView(url)
        return view
    }

    fun setWebView(url: String) {
        mywebview!!.settings.javaScriptEnabled = true
        val uri = Consts.POST_URL + url
        mywebview!!.loadUrl(uri)
    }

}