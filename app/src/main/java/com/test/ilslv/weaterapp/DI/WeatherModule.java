package com.test.ilslv.weaterapp.DI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.ilslv.weaterapp.Domain.WeatherContract;
import com.test.ilslv.weaterapp.Domain.WeatherInteractorImpl;
import com.test.ilslv.weaterapp.Domain.WeatherPresenterImpl;
import com.test.ilslv.weaterapp.WeatherApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WeatherModule {

    public static final String WEATHER_URL = " https://samples.openweathermap.org/data/";

    @Provides
    public WeatherApi provideWeatherApi() {
        return new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(WEATHER_URL)
                .build()
                .create(WeatherApi.class);
    }

    @Provides
    public WeatherContract.WeatherInteractor provideWeatherInteractor(WeatherApi weatherApi) {
        return new WeatherInteractorImpl(weatherApi);
    }

    @Provides
    public WeatherContract.WeatherPresenter provideWeatherPresenter(WeatherContract.WeatherInteractor weatherInteractor) {
        return new WeatherPresenterImpl(weatherInteractor);
    }

}
