package com.ck2020.mvpbasic.bas.mvp

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * @author chenke
 * @create 2020/6/30
 * @Describe
 */
interface IView {

    fun showLoading()

    fun showEmpty()

    fun showError()

    fun hideLoading()

    fun showDialogLoading()

    fun onReLoad()

    fun hideDialogLoading()

    fun showMessage(tipMessage: String?)

    fun findActivity(): RxAppCompatActivity

    fun findFragment(): RxFragment?
}