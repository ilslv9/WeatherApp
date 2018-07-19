package com.test.ilslv.weaterapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class WeatherDay {

    @Expose
    @SerializedName("dt")
    Date date;
    @Expose
    @SerializedName("temp")
    Temperature temperature;

    public WeatherDay(Date date, Temperature temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
