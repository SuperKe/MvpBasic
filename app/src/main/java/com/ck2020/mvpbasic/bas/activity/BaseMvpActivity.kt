package com.ck2020.mvpbasic.bas.activity

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ck2020.mvpbasic.R
import com.ck2020.mvpbasic.bas.mvp.IPresenter
import com.ck2020.mvpbasic.bas.mvp.IView
import com.classic.common.MultipleStatusView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * mvp
 */
abstract class BaseMvpActivity<P : IPresenter> : BaseActivity(), IView {
    private var mPresenter: P? = null

    /**
     * onCreate中创建presenter
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = setUpPresenter()
    }

    /**
     * 默认不使用eventBus
     */
    override fun useEventBus(): Boolean {
        return false
    }

    abstract fun setUpPresenter(): P?

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
        mPresenter = null
    }

    var mStatusView: MultipleStatusView? = null
    override fun showLoading() {
        if (mStatusView == null) {
            val mViewRoot = window.decorView.findViewById<ViewGroup>(android.R.id.content).getChildAt(0) as ViewGroup
            if (mViewRoot.childCount != 0) {
                for (i in 0 until mViewRoot.childCount) {
                    if (mViewRoot.getChildAt(i) is MultipleStatusView) {
                        mStatusView = mViewRoot.getChildAt(i) as MultipleStatusView
                        mStatusView?.setOnRetryClickListener {
                            onReLoad()
                        }
                        break
                    }
                }
            }
        }
        mStatusView?.showLoading()
    }

    override fun showEmpty() {
        mStatusView?.showEmpty()
    }

    override fun showError() {
        mStatusView?.showEmpty()
    }

    override fun hideLoading() {
        mStatusView?.showContent()
    }

    var mAlertDialog: AlertDialog? = null
    override fun showDialogLoading() {
        mAlertDialog = AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog)
            .setView(R.layout.load_dialog_layout)
            .setCancelable(true).show()
    }

    override fun hideDialogLoading() {
        mAlertDialog?.dismiss()
    }

    override fun onReLoad() {

    }


    override fun showMessage(tipMessage: String?) {
        //Toast this
        Toast.makeText(this, tipMessage, Toast.LENGTH_SHORT).show()
    }

    override fun findActivity(): RxAppCompatActivity {
        return this
    }

    override fun findFragment(): RxFragment? {
        return null
    }
}