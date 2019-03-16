package com.hie2j.volleyjsonrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btn1;
    private ListView lv_weather;
    private ArrayList<Weather> weatherArrayList = new ArrayList<>();
    private WeatherAdapter weatherAdapter;

    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        btn1 = findViewById(R.id.btn1);
        lv_weather = findViewById(R.id.lv_weather);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useVolleyJsonRequest("101280101");

            }
        });
    }

    private void useVolleyJsonRequest(String cityCode) {
        if (weatherArrayList != null){
            weatherArrayList.clear();
        }
        String baseUrl = "http://t.weather.sojson.com/api/weather/city/";
        String weatherUrl = baseUrl.concat(cityCode);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(weatherUrl, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    for (int i = 0;i < 3;i++){
                        String date = jsonObject.getJSONObject("data").getJSONArray("forecast").getJSONObject(i).getString("date");
                        String low = jsonObject.getJSONObject("data").getJSONArray("forecast").getJSONObject(i).getString("low");
                        String high = jsonObject.getJSONObject("data").getJSONArray("forecast").getJSONObject(i).getString("high");
                        String type = jsonObject.getJSONObject("data").getJSONArray("forecast").getJSONObject(i).getString("type");
                        Log.e(TAG,"date = " + date + " low = " + low + " high = " + high + " type = " + type);
                        Weather weather = new Weather(date,low,high,type);
                        weatherArrayList.add(weather);
                    }
                    weatherAdapter = new WeatherAdapter(MainActivity.this,weatherArrayList);
                    Log.e(TAG, String.valueOf(weatherAdapter.getWeatherArrayList().size()));
                    lv_weather.setAdapter(weatherAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG,volleyError.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
