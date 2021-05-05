package com.example.dachuang.ui.common

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

/**
 * 应用程序中所有Activity的基类
 */
abstract class BaseActivity:AppCompatActivity() {

    /**
     * 判断当前Activity是否在前台。
     */
    protected var isActive: Boolean = false

    /**
     * 当前Activity的实例。
     */
    protected var activity: Activity? = null


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        layoutId()
        initView()
        initDate()
    }

    protected abstract fun layoutId(): Int


    abstract fun initView()

    abstract fun initDate()

}