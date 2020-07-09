package com.ck2020.mvpbasic.bas.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ck2020.mvpbasic.bas.mvp.IPresenter

/**
 * @author chenke
 * @create 2020/6/30
 * @Describe
 */
abstract class BaseLazyMvpFragment<P : IPresenter> : BaseMvpFragment<P>() {
    // 界面是否已创建完成
    private var isViewCreated = false

    // 是否对用户可见
    private var isVisibleToUser = false

    // 数据是否已请求
    private var isDataLoaded = false

    /**
     * 第一次可见时触发调用,此处实现具体的数据请求逻辑
     */
    protected abstract fun lazyLoadData()

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        tryLoadData()
    }

    /**
     * 保证在initData后触发
     */
    override fun onResume() {
        super.onResume()
        isViewCreated = true
        tryLoadData()
    }

    /**
     * ViewPager场景下，判断父fragment是否可见
     */
    private fun isParentVisible(): Boolean {
        val fragment: Fragment? = parentFragment
        return fragment == null || (fragment is BaseLazyMvpFragment<*> && fragment.isVisibleToUser)
    }

    /**
     * ViewPager场景下，当前fragment可见时，如果其子fragment也可见，则让子fragment请求数据
     */
    private fun dispatchParentVisibleState() {
        val fragmentManager: FragmentManager = childFragmentManager
        val fragments: List<Fragment> = fragmentManager.fragments
        if (fragments.isEmpty()) {
            return
        }
        for (child in fragments) {
            if (child is BaseLazyMvpFragment<*> && child.isVisibleToUser) {
                child.tryLoadData()
            }
        }
    }

    private fun tryLoadData() {
        if (isViewCreated && isVisibleToUser && isParentVisible() && !isDataLoaded) {
            lazyLoadData()
            isDataLoaded = true
            //通知子Fragment请求数据
            dispatchParentVisibleState()
        }
    }
}