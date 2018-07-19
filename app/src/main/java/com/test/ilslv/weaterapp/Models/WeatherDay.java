package com.test.ilslv.weaterapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class WeatherDay {

    @Expose
    @SerializedName("dt")
    long date;
    @Expose
    @SerializedName("temp")
    Temperature temperature;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
