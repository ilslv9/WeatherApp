package com.test.ilslv.weaterapp.Domain;

import com.test.ilslv.weaterapp.Models.WeatherModel;
import com.test.ilslv.weaterapp.WeatherApi;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherInteractorImpl implements WeatherContract.WeatherInteractor {

    WeatherApi weatherApi;

    @Inject
    public WeatherInteractorImpl(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public void getWeather(final OnFinishedListener onFinishedListener) {
        weatherApi.getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherModel>() {
                    @Override
                    public void accept(WeatherModel weatherModel) throws Exception {
                        onFinishedListener.onFinished(weatherModel.getWeatherDayList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onFinishedListener.onFailure(throwable);
                    }
                });
    }
}
