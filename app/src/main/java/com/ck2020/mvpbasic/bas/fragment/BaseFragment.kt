package com.ck2020.mvpbasic.bas.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.trello.rxlifecycle2.components.support.RxFragment


public abstract class BaseFragment : RxFragment() {
    private var mUnbinder: Unbinder? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)
        initView(view)
        mUnbinder = ButterKnife.bind(view)
        return view
    }

    /**
     * 视图布局
     */
    public abstract fun getLayout(): Int

    /**
     * 非kotlin在该方法下用butterKnife操作view
     */
    public abstract fun initView(view: View)

    /**
     * 是否使用eventBus
     */
    public abstract fun useEventBus(): Boolean

    /**
     * kotlin类在该方法下操作view
     */
    public abstract fun initView()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mUnbinder != null && mUnbinder !== butterknife.Unbinder.EMPTY) {
            mUnbinder!!.unbind()
        }
        mUnbinder = null
        if (useEventBus()) {
            // unRegister event
        }
    }
}