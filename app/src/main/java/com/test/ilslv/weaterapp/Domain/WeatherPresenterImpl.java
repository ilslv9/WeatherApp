package com.test.ilslv.weaterapp.Domain;

import com.test.ilslv.weaterapp.Models.WeatherDay;

import java.util.List;

import javax.inject.Inject;

public class WeatherPresenterImpl implements WeatherContract.WeatherPresenter, WeatherContract.WeatherInteractor.OnFinishedListener {

    WeatherContract.WeatherView weatherView;
    WeatherContract.WeatherInteractor weatherInteractor;

    @Inject
    public WeatherPresenterImpl(WeatherContract.WeatherInteractor weatherInteractor) {
        this.weatherInteractor = weatherInteractor;
    }

    @Override
    public void onCreate(WeatherContract.WeatherView weatherView) {
        this.weatherView = weatherView;
    }

    @Override
    public void loadingData() {
        weatherView.showLoading(true);
        weatherInteractor.getWeather(this);
    }

    @Override
    public void onDestroy() {
        weatherView = null;
    }

    @Override
    public void onFinished(List<WeatherDay> days) {
        weatherView.showLoading(false);
        weatherView.showData(days);
    }

    @Override
    public void onFailure(Throwable t) {
        weatherView.showLoading(false);
        weatherView.showError();
    }
}
