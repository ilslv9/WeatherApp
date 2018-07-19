package com.test.ilslv.weaterapp;

import android.app.Application;

import com.test.ilslv.weaterapp.DI.DaggerWeatherComponent;
import com.test.ilslv.weaterapp.DI.WeatherComponent;

public class WeatherApp extends Application {

    private static WeatherComponent weatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        weatherComponent = DaggerWeatherComponent.builder().build();
    }

    public static WeatherComponent getWeatherComponent(){
        return weatherComponent;
    }
}
