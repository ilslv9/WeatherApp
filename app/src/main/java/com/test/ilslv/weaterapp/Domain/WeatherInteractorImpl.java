package com.test.ilslv.weaterapp.Domain;

import com.test.ilslv.weaterapp.WeatherApi;

import javax.inject.Inject;

public class WeatherInteractorImpl implements WeatherContract.WeatherInteractor {

    WeatherApi weatherApi;

    @Inject
    public WeatherInteractorImpl(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public void getWeather(final OnFinishedListener onFinishedListener) {

    }
}
