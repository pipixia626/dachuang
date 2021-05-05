package com.example.dachuang.util

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.*

/**
 * 管理应用程序中所有Activity
 */
object ActivityUtil {

    private val activities=Stack<WeakReference<Activity>>()

    /**
     * 将Activity压入Application栈
     */
    fun pushTask(task:WeakReference<Activity>?){
        activities.push(task)
    }

    /**
     * 将压入栈中的Activity对象从栈中移除
     */

    fun removeTask(task:WeakReference<Activity>?){
        activities.remove(task)
    }


    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */
    fun removeTask(taskIndex: Int) {
        if (activities.size > taskIndex) activities.removeAt(taskIndex)
    }

    /**
     * 将栈中Activity移除至栈顶
     */
    fun removeToTop() {
        val end = activities.size
        val start = 1
        for (i in end - 1 downTo start) {
            val mActivity = activities[i].get()
            if (null != mActivity && !mActivity.isFinishing) {
                mActivity.finish()
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    fun removeAll() {
        for (task in activities) {
            val mActivity = task.get()
            if (null != mActivity && !mActivity.isFinishing) {
                mActivity.finish()
            }
        }
    }
}