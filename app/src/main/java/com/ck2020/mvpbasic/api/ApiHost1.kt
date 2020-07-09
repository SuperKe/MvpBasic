package com.ck2020.mvpbasic.api

import com.ck2020.mvpbasic.ResponseBean
import com.ck2020.mvpbasic.WeatherBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author chenke
 * @create 2020/7/7
 * @Describe
 */
interface ApiHost1 {
    @GET("weather_mini?city=成都")
    fun weather(): Observable<ResponseBean<WeatherBean>>

    @GET("weather_mini")
    fun weather2(@Query("city") city: String): Observable<ResponseBean<WeatherBean>>
}