package com.ck2020.mvpbasic;

import android.widget.TextView;

import com.ck2020.mvpbasic.bas.mvp.IModel;
import com.ck2020.mvpbasic.bas.mvp.IView;

import io.reactivex.Observable;


/**
 * @author chenke
 * @create 2020/7/7
 * @Describe
 */
public interface TestContact {

    public interface TestView extends IView {
        TextView bindTest();
    }

    public interface TestModel extends IModel {
        Observable<ResponseBean<WeatherBean>> getWeather();

        Observable<ResponseBean<WeatherBean>> getWeather2(String city);
    }
}
