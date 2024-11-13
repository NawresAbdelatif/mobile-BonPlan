package com.example.commentaire;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SentimentApiService {
    @POST("v1/analyze")
    Call<SentimentResponse> analyzeSentiment(@Body Comment comment);
}

