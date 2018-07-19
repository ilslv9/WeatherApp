package com.test.ilslv.weaterapp.Models;

import com.google.gson.annotations.Expose;

public class Temperature {
    @Expose
    double day;
    @Expose
    double mix;
    @Expose
    double max;

    public Temperature(double day, double mix, double max) {
        this.day = day;
        this.mix = mix;
        this.max = max;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMix() {
        return mix;
    }

    public void setMix(double mix) {
        this.mix = mix;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
