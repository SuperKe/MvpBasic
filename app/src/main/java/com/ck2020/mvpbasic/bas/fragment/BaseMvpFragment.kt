package com.ck2020.mvpbasic.bas.fragment

import com.ck2020.mvpbasic.bas.mvp.IPresenter
import com.ck2020.mvpbasic.bas.mvp.IView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment

abstract class BaseMvpFragment<P : IPresenter> : BaseFragment(), IView {

    private var mPresenter: P? = null

    /**
     * 默认不使用eventBus
     */
    override fun useEventBus(): Boolean {
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
        mPresenter = null
    }
    //与activity一致

    override fun showLoading() {

    }

    override fun showEmpty() {

    }

    override fun showError() {

    }

    override fun hideLoading() {

    }

    override fun showDialogLoading() {

    }

    override fun onReLoad() {

    }

    override fun hideDialogLoading() {

    }

    override fun showMessage(tipMessage: String?) {
        //
    }

    override fun findActivity(): RxAppCompatActivity {
        return activity as RxAppCompatActivity
    }

    override fun findFragment(): RxFragment? {
        return this
    }
}