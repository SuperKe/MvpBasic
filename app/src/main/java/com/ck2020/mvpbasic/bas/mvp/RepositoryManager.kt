package com.ck2020.mvpbasic.bas.mvp

import com.ck2020.mvpbasic.api.ApiHost1
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author chenke
 * @create 2020/6/30
 * @Describe retrofit网络创建层
 */
public class RepositoryManager : IRepositoryManager {

    private val URL_1 = "http://wthrcdn.etouch.cn/"

    var retrofit1 = Retrofit.Builder()
        .baseUrl(URL_1)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


    fun <T> create(serviceClass: Class<T>): T = retrofit1.create(serviceClass)

    private var apiHost1: ApiHost1? = null
    override fun getApiHost1(): ApiHost1 {
        if (apiHost1 == null) {
            apiHost1 = create(ApiHost1::class.java)
        }
        return apiHost1 as ApiHost1
    }

    override fun getApiHost2() {

    }

    override fun getApiHost3() {

    }


}