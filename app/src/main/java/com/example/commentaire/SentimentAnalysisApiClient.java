package com.example.commentaire;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SentimentAnalysisApiClient {
    private static final String BASE_URL = "https://aylien.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

