package com.ck2020.mvpbasic.bas.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author chenke
 * @create 2020/6/30
 * @Describe
 */
open class BaseModel : IModel, LifecycleObserver {
    protected var mRepositoryManager: IRepositoryManager? = null

    /**
     * model层为数据层，所以需要retrofit实例来请求网络
     */
    constructor(repositoryManager: IRepositoryManager) {
        this.mRepositoryManager = repositoryManager
    }

    /**
     * presenter在onDestroy时调用
     * 释放资源
     */
    override fun onDestroy() {
        mRepositoryManager = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner) {
        owner.lifecycle.removeObserver(this)
    }
}