package com.test.ilslv.weaterapp.Domain;

import com.test.ilslv.weaterapp.Models.WeatherDay;

import java.util.List;

public interface WeatherContract {
    interface WeatherView{
        void showLoading(Boolean isLoading);
        void showData(List<WeatherDay> days);
        void showError();
    }
    interface WeatherPresenter{
        void onCreate(WeatherView weatherView);
        void loadingData();
    }

    interface WeatherInteractor{
        void getWeather(final OnFinishedListener onFinishedListener);

        interface OnFinishedListener{
            void onFinished(List<WeatherDay> days);
            void onFailure(Throwable t);
        }
    }
}
