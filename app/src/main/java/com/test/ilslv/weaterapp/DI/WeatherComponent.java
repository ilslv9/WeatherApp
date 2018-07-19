package com.test.ilslv.weaterapp.DI;

import com.test.ilslv.weaterapp.UI.WeatherFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {WeatherModule.class})
@Singleton
public interface WeatherComponent {
    void injet(WeatherFragment weatherFragment);
}
