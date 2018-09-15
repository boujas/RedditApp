package com.example.user.myapplication.utils

import org.joda.time.DateTime
import org.joda.time.Period

class CommonUtil {

    companion object {
        fun getCommentCount(commentCount: Int): String {
            var comments = commentCount.toString()
            if (commentCount > 1000)
                comments = (commentCount / 1000).toString() + Consts.THOSANDS
            return comments
        }

        fun getWeeksCount(date1: String): String {
            val date = DateTime(date1.toFloat().toLong() * 1000)
            val p = Period(DateTime(), date)
            val minutes = p.minutes
            val hours = p.hours
            val weeks = p.weeks
            if (hours < 1)
                return minutes.toString() + Consts.TIME_MIN
            else if (hours < 24)
                return hours.toString() + Consts.TIME_HOURS
            else
                return weeks.toString() + Consts.TIME_WEEKS
        }
    }


}