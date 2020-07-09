package com.ck2020.mvpbasic

import android.widget.TextView
import com.ck2020.mvpbasic.bas.activity.BaseMvpActivity
import com.ck2020.mvpbasic.bas.mvp.RepositoryManager
import kotlinx.android.synthetic.main.activity_weather_activty.*

class WeatherActivity : BaseMvpActivity<TestPresenter>(), TestContact.TestView {

    override fun setUpPresenter(): TestPresenter? {
        return TestPresenter(TestModel(RepositoryManager()), this)
    }

    override fun initView() {

    }

    override fun getLayout(): Int {
        return R.layout.activity_weather_activty
    }


    override fun bindTest(): TextView {
        return tv_content
    }
}