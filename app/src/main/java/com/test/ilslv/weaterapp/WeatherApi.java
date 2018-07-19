package com.test.ilslv.weaterapp;

import com.test.ilslv.weaterapp.Models.WeatherModel;

import java.security.Signature;
import java.util.Observable;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WeatherApi {
    @GET("data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1")
    Single<WeatherModel> getWeather();
}
