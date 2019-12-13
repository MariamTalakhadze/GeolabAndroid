package com.example.weather_app.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiManager {
        private static Retrofit retrofit;
        private static OkHttpClient okHttpClient;
        private static HttpLoggingInterceptor interceptor;

        private static Retrofit getRetrofit(){
            if (retrofit==null){
                interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build();
                retrofit = new Retrofit.Builder()
                        .baseUrl(ApiEndPoints.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build();
            }
            return retrofit;
        }
    }
