package com.hie2j.volleyjsonrequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Weather> weatherArrayList;

    public ArrayList<Weather> getWeatherArrayList() {
        return weatherArrayList;
    }

    public void setWeatherArrayList(ArrayList<Weather> weatherArrayList) {
        this.weatherArrayList = weatherArrayList;
    }

    public WeatherAdapter(Context context, ArrayList<Weather> weatherArrayList) {
        this.context = context;
        this.weatherArrayList = weatherArrayList;
    }

    @Override
    public int getCount() {
        return weatherArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.lv_weather,parent,false);
            WeatherHolder weatherHolder = new WeatherHolder();
            weatherHolder.txt_Date = convertView.findViewById(R.id.txt_date);
            weatherHolder.txt_Low = convertView.findViewById(R.id.txt_low);
            weatherHolder.txt_High = convertView.findViewById(R.id.txt_high);
            weatherHolder.img_Type = convertView.findViewById(R.id.img_type);

            convertView.setTag(weatherHolder);
        }

        Weather weather = weatherArrayList.get(position);
        WeatherHolder weatherHolder = (WeatherHolder) convertView.getTag();
        weatherHolder.txt_Date.setText(weather.getDate()+"号");
        weatherHolder.txt_Low.setText(weather.getLow());
        weatherHolder.txt_High.setText(weather.getHigh());
//        if (weather.getType().equals("qing")){
//            weatherHolder.img_Type.setImageResource(R.drawable.qing);
//        }else if (weather.getType().equals("duoyun")){
//            weatherHolder.img_Type.setImageResource(R.drawable.duoyun);
//        }else if (weather.getType().equals("yin")){
//            weatherHolder.img_Type.setImageResource(R.drawable.yin);
//        }else if (weather.getType().equals("xiaoyu")){
//            weatherHolder.img_Type.setImageResource(R.drawable.xiaoyu);
//        }else if (weather.getType().equals("zhongyu")){
//            weatherHolder.img_Type.setImageResource(R.drawable.zhongyu);
//        }else if (weather.getType().equals("dayu")){
//            weatherHolder.img_Type.setImageResource(R.drawable.dayu);
//        }else if (weather.getType().equals("baoyu")){
//            weatherHolder.img_Type.setImageResource(R.drawable.baoyu);
//        }else if (weather.getType().equals("zhenyu")){
//            weatherHolder.img_Type.setImageResource(R.drawable.zhenyu);
//        }
        switch (weather.getType()){
            case "晴":
                weatherHolder.img_Type.setImageResource(R.drawable.qing);
                break;
            case "多云":
                weatherHolder.img_Type.setImageResource(R.drawable.duoyun);
                break;
            case "阴":
                weatherHolder.img_Type.setImageResource(R.drawable.yin);
                break;
            case "小雨":
                weatherHolder.img_Type.setImageResource(R.drawable.xiaoyu);
                break;
            case "中雨":
                weatherHolder.img_Type.setImageResource(R.drawable.zhongyu);
                break;
            case "大雨":
                weatherHolder.img_Type.setImageResource(R.drawable.dayu);
                break;
            case "暴雨":
                weatherHolder.img_Type.setImageResource(R.drawable.baoyu);
                break;
            case "阵雨":
                weatherHolder.img_Type.setImageResource(R.drawable.zhenyu);
                break;
        }

        return convertView;
    }
}
