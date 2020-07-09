package com.ck2020.mvpbasic

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.ck2020.mvpbasic.bas.mvp.BaseModel
import com.ck2020.mvpbasic.bas.mvp.IRepositoryManager
import io.reactivex.Observable

/**
 * @author chenke
 * @create 2020/7/7
 * @Describe
 */
class TestModel : BaseModel, TestContact.TestModel {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onActivityDestroy() {
        Log.i("gw", "model感知activity生命周期")
    }

    constructor(repositoryManager: IRepositoryManager) : super(repositoryManager)

    override fun getWeather(): Observable<ResponseBean<WeatherBean>> {
        return mRepositoryManager?.getApiHost1()?.weather()!!
    }

    override fun getWeather2(city: String): Observable<ResponseBean<WeatherBean>> {
        return mRepositoryManager?.getApiHost1()?.weather2(city)!!
    }
}