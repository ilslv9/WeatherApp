package com.test.ilslv.weaterapp.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.ilslv.weaterapp.Domain.WeatherContract;
import com.test.ilslv.weaterapp.Models.WeatherDay;
import com.test.ilslv.weaterapp.R;
import com.test.ilslv.weaterapp.WeatherApp;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class WeatherFragment extends Fragment implements WeatherContract.WeatherView {

    @Inject
    WeatherContract.WeatherPresenter weatherPresenter;
    RecyclerView weatherView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherApp.getWeatherComponent().injet(this);
        weatherPresenter.onCreate(this);
        weatherPresenter.loadingData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        weatherPresenter.onDestroy();
    }

    @Override
    public void showLoading(Boolean isLoading) {

    }

    @Override
    public void showData(List<WeatherDay> days) {

    }

    @Override
    public void showError() {

    }
}
