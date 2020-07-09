package com.ck2020.mvpbasic.bas.mvp

import android.app.Activity

/**
 * @author chenke
 * @create 2020/6/30
 * @Describe
 */
interface IPresenter {
    /**
     * 做一些初始化操作
     */
    fun onStart()

    /**
     * 在[Activity.onDestroy] 时会默认调用 [IPresenter.onDestroy]
     */
    fun onDestroy()
}