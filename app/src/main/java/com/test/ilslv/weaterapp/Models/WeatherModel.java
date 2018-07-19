package com.test.ilslv.weaterapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherModel {

    @Expose
    @SerializedName("list")
    private List<WeatherDay> weatherDayList;

    public List<WeatherDay> getWeatherDayList() {
        return weatherDayList;
    }

    public void setWeatherDayList(List<WeatherDay> weatherDayList) {
        this.weatherDayList = weatherDayList;
    }
}
