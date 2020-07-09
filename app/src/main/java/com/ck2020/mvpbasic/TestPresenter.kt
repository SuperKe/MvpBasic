package com.ck2020.mvpbasic

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.ck2020.mvpbasic.bas.mvp.BasePresenter
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * @author chenke
 * @create 2020/7/7
 * @Describe
 */
class TestPresenter : BasePresenter<TestContact.TestModel, TestContact.TestView> {

    constructor(model: TestContact.TestModel, rootView: TestContact.TestView) : super(model, rootView)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("gw", "activity onCreate")
        mRootView.showDialogLoading()
        mModel.getWeather2("成都")
            .delay(2000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(mRootView.findActivity().bindUntilEvent(ActivityEvent.DESTROY))
            .subscribe(object : Observer<ResponseBean<WeatherBean>> {
                override fun onComplete() {
                    mRootView.hideDialogLoading()
                }

                override fun onSubscribe(d: Disposable) {
                    addDispose(d)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    mRootView.bindTest().text = "${e.message}"
                }

                override fun onNext(t: ResponseBean<WeatherBean>) {
                    Log.i("gw", "请求成功")
                    mRootView.showMessage("请求成功")
                    mRootView.bindTest().text = "${t.data.city}"
                }
            })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onActivityDestroy() {
        Log.i("gw", "activity finish")
        Log.i("gw", "mRootView:$mRootView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("gw", "presenter销毁了")
        Log.i("gw", "mRootView:$mRootView")
    }
}

