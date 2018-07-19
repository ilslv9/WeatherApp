package com.test.ilslv.weaterapp.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.test.ilslv.weaterapp.Domain.WeatherContract;
import com.test.ilslv.weaterapp.Models.WeatherDay;
import com.test.ilslv.weaterapp.R;
import com.test.ilslv.weaterapp.WeatherApp;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WeatherFragment extends Fragment implements WeatherContract.WeatherView {

    @Inject
    WeatherContract.WeatherPresenter weatherPresenter;
    RecyclerView weatherView;
    ProgressBar progressBar;
    TextView error;
    WeatherAdapter weatherAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        weatherView = getActivity().findViewById(R.id.daysView);
        progressBar = getActivity().findViewById(R.id.progressBar);
        error = getActivity().findViewById(R.id.error);

        WeatherApp.getWeatherComponent().injet(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        weatherView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(weatherView.getContext(),
                linearLayoutManager.getOrientation());
        weatherView.addItemDecoration(dividerItemDecoration);
        weatherPresenter.onCreate(this);
        weatherPresenter.loadingData();

    }

    @Override
    public void showLoading(Boolean isLoading) {
        if (isLoading) {
            weatherView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            weatherView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showData(List<WeatherDay> days) {
        weatherAdapter = new WeatherAdapter(getActivity().getApplicationContext(), days);
        weatherView.setAdapter(weatherAdapter);
    }

    @Override
    public void showError() {
        weatherView.setVisibility(View.GONE);
        error.setText("Ooops... Something went wrong!");
        error.setVisibility(View.VISIBLE);
    }
}
