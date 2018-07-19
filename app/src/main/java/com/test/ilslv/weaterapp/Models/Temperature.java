package com.test.ilslv.weaterapp.Models;

import com.google.gson.annotations.Expose;

public class Temperature {
    @Expose
    double day;
    @Expose
    double min;
    @Expose
    double max;

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
