package com.example.homeapi.Helper

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context, attr:  AttributeSet): ViewPager(context, attr) {

    private var disable:Boolean= false


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        return when (disable) {
            true -> super.onTouchEvent(ev)
            false -> false
        }
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return when (disable) {
            true -> super.onInterceptTouchEvent(ev)
            false -> false
        }
    }
    fun disableScroll(d:Boolean)
    {
        disable=d
    }
}