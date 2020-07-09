package com.ck2020.mvpbasic.bas.mvp

import com.ck2020.mvpbasic.api.ApiHost1

/**
 * @author chenke
 * @create 2020/6/30
 * @Describe
 */
interface IRepositoryManager {
    /**
     * 对应不同的baseUrl
     */
    fun getApiHost1(): ApiHost1

    fun getApiHost2()

    fun getApiHost3()
}