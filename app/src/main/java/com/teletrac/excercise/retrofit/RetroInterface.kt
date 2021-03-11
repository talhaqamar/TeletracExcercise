package com.teletrac.excercise.retrofit

import com.teletrac.excercise.data.WeatherResult
import retrofit2.Call
import retrofit2.http.GET

interface RetroInterface {
    @GET("forecast?id=524901&appid=b6907d289e10d714a6e88b30761fae22")
    fun getWeatherData(): Call<WeatherResult>
}