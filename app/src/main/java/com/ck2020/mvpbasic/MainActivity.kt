package com.ck2020.mvpbasic

import android.content.Intent
import com.ck2020.mvpbasic.bas.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun useEventBus(): Boolean {
        return false
    }

    override fun initView() {
        tv_content.setOnClickListener {
            startActivity(Intent(MainActivity@ this, WeatherActivity::class.java))
        }
    }
}