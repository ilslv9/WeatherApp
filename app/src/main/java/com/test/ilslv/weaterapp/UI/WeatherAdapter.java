package com.test.ilslv.weaterapp.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test.ilslv.weaterapp.Models.WeatherDay;
import com.test.ilslv.weaterapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    Context context;
    List<WeatherDay> days;

    public WeatherAdapter(Context context, List<WeatherDay> days) {
        this.context = context;
        this.days = days;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        final WeatherDay weatherDay = days.get(i);
        final Locale loc = new Locale("ru");
        final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", loc);
        format.setTimeZone(TimeZone.getDefault());

        holder.date.setText(format.format(new Date(weatherDay.getDate()*1000)));
        holder.day.setText(String.valueOf(weatherDay.getTemperature().getDay()));
        holder.min.setText(String.valueOf(weatherDay.getTemperature().getMin()));
        holder.max.setText(String.valueOf(weatherDay.getTemperature().getMax()));
        holder.weather.setText(weatherDay.getWeather().get(0).getMain());

        holder.dayContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, format.format(new Date(weatherDay.getDate()*1000)), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.day)
        TextView day;
        @BindView(R.id.min)
        TextView min;
        @BindView(R.id.max)
        TextView max;
        @BindView(R.id.weather)
        TextView weather;
        @BindView(R.id.dayConatiner)
        ConstraintLayout dayContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
