package com.ck2020.mvpbasic.bas.activity

import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import butterknife.ButterKnife
import butterknife.Unbinder
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * baseActivity基类
 * 视图层，可自行拓展沉浸式等
 * 如果定义增多，建议新增IActivity接口以做规范
 */
abstract class BaseActivity : RxAppCompatActivity(), LifecycleObserver {
    private var mUnbinder: Unbinder? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mUnbinder = ButterKnife.bind(this)
        if (useEventBus()) {
            //register event
        }
        initView()
    }

    /**
     * 布局的layout
     */
    abstract fun getLayout(): Int

    /**
     * 是否使用eventBus
     */
    abstract fun useEventBus(): Boolean

    /**
     * 视图回调，这里是子类的开始
     */
    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        if (mUnbinder != null && mUnbinder !== Unbinder.EMPTY) {
            mUnbinder!!.unbind()
        }
        mUnbinder = null
        if (useEventBus()) {
            // unRegister event
        }
    }
}