package com.test.ilslv.weaterapp.Models;

import com.google.gson.annotations.Expose;

public class Weather {

    @Expose
    String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
